package com.htcs.wework.salarybill.service.impl;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import com.htcs.wework.common.model.LoginSysUser;
import com.htcs.wework.common.sec.AES;
import com.htcs.wework.common.util.DateTimeUtils;
import com.htcs.wework.salarybill.dao.SalaryBillDao;
import com.htcs.wework.salarybill.dao.SalaryEnterpriseIdDao;
import com.htcs.wework.salarybill.dao.SalaryQuestionDao;
import com.htcs.wework.salarybill.dao.SalaryTransformDao;
import com.htcs.wework.salarybill.model.SalaryBill;
import com.htcs.wework.salarybill.model.SalaryEnterpriseId;
import com.htcs.wework.salarybill.model.SalaryEnterpriseIdQuery;
import com.htcs.wework.salarybill.model.SalaryQuestion;
import com.htcs.wework.salarybill.model.SalaryQuestionQuery;
import com.htcs.wework.salarybill.model.SalaryTransform;
import com.htcs.wework.salarybill.model.WebWeworkMessage;
import com.htcs.wework.salarybill.service.SalaryBillAdminService;
import com.htcs.wework.salarybill.util.ConvertSalaryBill;

import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.cp.api.WxCpService;
import me.chanjar.weixin.cp.bean.WxCpMessage;
@Service("salaryBillAdminService")
public class SalaryBillAdminServiceImpl implements SalaryBillAdminService {

	@Autowired
	private SalaryBillDao salaryBillDao;
	
	@Value("${enterprise.agentId}")
	private String  agentid;
	
	@Autowired
	private  SalaryTransformDao  salaryTransformDao;
	
	@Autowired
	private SalaryEnterpriseIdDao salaryEnterpriseIdDao;
	
	@Autowired
	private SalaryQuestionDao salaryQuestionDao;
	
	@Autowired
	private WxCpService wxCpService;
		
	public Map<String,Object> listSalaryBillsByCondition(String username,Integer status,
											String salaryDate,int pageNum,int pageSize) {
		if (salaryDate != null && salaryDate.length() < 7 ) {
			throw new RuntimeException("日期格式错误");
		}
		Map<String,Object> listMap = new HashMap<String,Object>();
		List<SalaryBill> salaryList =  salaryBillDao.getSalaryBillsByCondition(username,status,salaryDate,(pageNum-1)*pageSize,pageSize);
		for (SalaryBill s: salaryList) {
			String name = s.getName();
			SalaryEnterpriseIdQuery sedq = new SalaryEnterpriseIdQuery();
			sedq.createCriteria().andUserNameEqualTo(name);
			List<SalaryEnterpriseId> idList = salaryEnterpriseIdDao.selectByExample(sedq);
			if (idList != null && idList.size() !=0) {
				String enterpriseId = idList.get(0).getEnterpriseId();
				s.setEnterpriseId(enterpriseId);
			}
			if (s.getProblem() == 1) {
				SalaryQuestionQuery salaryQuestionQuery = new SalaryQuestionQuery();
				salaryQuestionQuery.createCriteria().andSalaryBillIdEqualTo(s.getId());
				List<SalaryQuestion> questions = salaryQuestionDao.selectByExample(salaryQuestionQuery);
				s.setProblems(questions);
			} else {
				s.setProblems(new ArrayList<SalaryQuestion>());
			}
			ConvertSalaryBill.convertSalaryBill(s);
		}
		listMap.put("list",salaryList);
		int cout =  salaryBillDao.countSalaryBillsByCondition(username,status,salaryDate,(pageNum-1)*pageSize,pageSize);
		listMap.put("cout", cout);
		listMap.put("page", Math.ceil(cout*1.0/pageSize));	
		return listMap;
	}

	@Transactional
	public void addSalaryTransforms(MultipartFile file, String money, String salarybillId, String salaryDate, String enterpriseId, LoginSysUser  user) {
		if (file == null ) {
			throw new RuntimeException("导入凭据失败");
		}
		SalaryBill salaryBillDb = salaryBillDao.selectByPrimaryKey(Integer.parseInt(salarybillId));
		if (salaryBillDb.getStatus() < 2) {
			throw new RuntimeException("导入凭据失败");
		}
		SalaryTransform salaryTransform = new SalaryTransform();
		try {			
			salaryTransform.setImage(file.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
		salaryTransform.setMoney(new Double(Double.parseDouble(money)*100).intValue());
		salaryTransform.setSalaryBillId(Integer.parseInt(salarybillId));
		salaryTransform.setCreateBy(user.getId());
		salaryTransform.setCreateName(user.getUserName());
		salaryTransform.setUpdateBy(user.getId());
		salaryTransform.setUpdateName(user.getUserName());
		salaryTransformDao.insertSelective(salaryTransform);
		SalaryBill salaryDb = salaryBillDao.selectByPrimaryKey(Integer.parseInt(salarybillId));
		SalaryBill salaryBill = new SalaryBill();
		salaryBill.setId(Integer.parseInt(salarybillId));
		salaryBill.setStatus(3);
		int alreadyPay = 0;
		if ("0".equals(salaryDb.getAlreadyPay())) {
			alreadyPay += new Double(Double.parseDouble(money)*100).intValue();
		} else {
			alreadyPay = new Double(Double.parseDouble(money)*100).intValue()+Integer.parseInt(AES.decryptFromBase64(salaryDb.getAlreadyPay(), ConvertSalaryBill.ENCRYPTKEY));
		}
		salaryBill.setAlreadyPay(AES.encryptToBase64(alreadyPay+"", ConvertSalaryBill.ENCRYPTKEY));
		salaryBillDao.updateByPrimaryKeySelective(salaryBill);
		WxCpMessage wxCpMessage = WxCpMessage
				  .TEXT() 
				  .agentId(Integer.parseInt(agentid)) // 企业号应用ID
				  .toUser(enterpriseId)
				  .content(salaryDate+"已打款￥"+money+"<a href=\"https://open.weixin.qq.com/connect/oauth2/authorize?appid=wwe4faf154efbc8119&redirect_uri=http%3A%2F%2Fsalarybill.hbwrrj.com%2Fsalarybill%2Fweb%2Fsalarybill%2FgetUserInfoMessage&response_type=code&scope=snsapi_base&state="+salarybillId+"#wechat_redirect\">点击查看</a>")
				  .build();
		try {
			wxCpService.messageSend(wxCpMessage);
		} catch (WxErrorException e) {
			throw new RuntimeException("发送消息失败");
		}
		
	}

	@Transactional
	public void sendWebChatMessage(WebWeworkMessage webChatMessage,LoginSysUser  user) {
		if (webChatMessage == null) {
			throw new RuntimeException("信息为空");
		}
		String[] salarybillIds = getSingleStr(webChatMessage.getSalarybillIds());
		String[] salaryDates = getSingleStr(webChatMessage.getSalaryDates());
		String[] enterpriseIds = getSingleStr(webChatMessage.getEnterpriseIds());
		for (String s: salarybillIds) {
			SalaryBill salaryBill = salaryBillDao.selectByPrimaryKey(Integer.parseInt(s));
			int status = salaryBill.getStatus();
			if (status > 0) {
				throw new RuntimeException("数据错误");
			}
		}
		for (int i = 0; i < enterpriseIds.length; i++) {
			WxCpMessage wxCpMessage = WxCpMessage
					  .TEXT() 
					  .agentId(Integer.parseInt(agentid)) // 企业号应用ID
					  .toUser(enterpriseIds[i])
					  .content(salaryDates[i]+webChatMessage.getContent()+"<a href=\"https://open.weixin.qq.com/connect/oauth2/authorize?appid=wwe4faf154efbc8119&redirect_uri=http%3A%2F%2Fsalarybill.hbwrrj.com%2Fsalarybill%2Fweb%2Fsalarybill%2FgetUserInfoMessage&response_type=code&scope=snsapi_base&state="+salarybillIds[i]+"#wechat_redirect\">点击查看</a>")
					  .build();
			try {
				wxCpService.messageSend(wxCpMessage);
			} catch (WxErrorException e) {
				e.printStackTrace();
			}
	        SalaryBill salaryBill = new SalaryBill();
	        salaryBill.setStatus(1);
	        salaryBill.setUpdateName(user.getUserName());
	        salaryBill.setUpdateBy(user.getId());
	        salaryBill.setUpdateTime(new Date());
	        salaryBill.setId(Integer.parseInt(salarybillIds[i]));
	        salaryBillDao.updateByPrimaryKeySelective(salaryBill);
		}
	}

	@SuppressWarnings("resource")
	@Transactional
	public void addSalaryBills(MultipartFile file,LoginSysUser  user) {
		  FileInputStream fis = null;
		  try {
				 fis = (FileInputStream) file.getInputStream();
		  } catch (FileNotFoundException e1) {
				e1.printStackTrace();
		  } catch (IOException e) {
			e.printStackTrace();
		} 
		  XSSFWorkbook workbook=null;
		  try {
		        workbook=new XSSFWorkbook(fis);
		  } catch (Exception e) {
			  throw new  RuntimeException("解析excel发生错误");
		  }
		  XSSFSheet sheet = workbook.getSheetAt(0);
		  for (int rowIndex = 0; rowIndex <= sheet.getLastRowNum(); rowIndex++) {  
			  if(rowIndex == 0) {
				  continue;
			  }
			  XSSFRow row = sheet.getRow(rowIndex);  
			  if (row == null) {  
	                continue;  
	           }
			  XSSFCell cell = null;	
			 
			  SalaryBill salaryBill = new SalaryBill();
			  for (int columnIndex = 0; columnIndex <= row.getLastCellNum(); columnIndex++) {  
				   String value = ""; 
				   cell = row.getCell(columnIndex); 
				   if (cell != null) {  
					   //如果出现乱码cell.setEncoding(HSSFCell.ENCODING_UTF_16); 
					   switch(cell.getCellTypeEnum()) {
					       case STRING : value = cell.getStringCellValue();
					       			break;
					       case NUMERIC : 
					    	   		if(HSSFDateUtil.isCellDateFormatted(cell)) {
					    	   			  Date date = cell.getDateCellValue();  
						    	   		  if (date != null) {  
				                                value = new SimpleDateFormat("yyyy-MM-dd")  
				                                        .format(date);  
				                            } else {  
				                                value = "";  
				                            }  
					    	   		}else {
					    	   			value = new DecimalFormat("0").format(cell  
			                                    .getNumericCellValue()*100); ;
					    	   		}
					       			break;
					       default: break;
					   }
					   salaryBill = setSalaryBill(salaryBill,columnIndex,value);
				   }
			  }
			  
			  String username = salaryBill.getName();
			  String date = DateTimeUtils.getTime("yyyy-MM",salaryBill.getSalaryDate());
			  SalaryBill salaryDb = salaryBillDao.getSalaryByNameAndDate(username, date);
			  if(salaryDb == null) {
				  salaryBill.setProblem((byte)0);
				  salaryBill.setCreateBy(user.getId());
				  salaryBill.setCreateName(user.getUserName());
				  salaryBill.setUpdateBy(user.getId());
				  salaryBill.setUpdateName(user.getUserName());
				  salaryBill.setStatus(0);
				  salaryBill.setAlreadyPay("0");
				  salaryBillDao.insertSelective(salaryBill);
			  }else {
				  int id = salaryDb.getId();
				  int status = salaryDb.getStatus();
				  byte problem = salaryDb.getProblem();
				  salaryBill.setId(id);
				  salaryBill.setStatus(status);
				  salaryBill.setProblem(problem);
				  salaryBill.setAlreadyPay("0");
				  if(status > 1 ) {
					  continue;
				  }
				  salaryBill.setLogicalDel(salaryDb.getLogicalDel());
				  salaryBill.setCreateBy(salaryDb.getCreateBy());
				  salaryBill.setCreateName(salaryDb.getCreateName());
				  salaryBill.setCreateTime(salaryDb.getCreateTime());
				  salaryBill.setCreateBy(user.getId());
				  salaryBill.setCreateName(user.getUserName());
				  salaryBill.setUpdateBy(user.getId());
				  salaryBill.setUpdateName(user.getUserName());
				  salaryBill.setUpdateTime(new Date());
				  salaryBillDao.updateByPrimaryKey(salaryBill);
			  }
		  }	  
	}
	
	/**
	 * 将解析的excel数据封装成对象
	 */
	private SalaryBill  setSalaryBill(SalaryBill salaryBill,int index,String value) {
		switch(index) {
			case 0 : salaryBill.setName(value);
				break;
			case 1 : salaryBill.setEntryTime(DateTimeUtils.toDate(value, "yyyy-MM-dd"));
				break;
			case 2 : salaryBill.setDutyAttendance(AES.encryptToBase64(Integer.parseInt(value)/100+"", ConvertSalaryBill.ENCRYPTKEY));
				break;
			case 3 : salaryBill.setActualAttendance(AES.encryptToBase64(Integer.parseInt(value)/100+"", ConvertSalaryBill.ENCRYPTKEY));
				break;
			case 4 : salaryBill.setBaseSalary(AES.encryptToBase64(Integer.parseInt(value)+"", ConvertSalaryBill.ENCRYPTKEY));
				break;
			case 5 : salaryBill.setPercentage(AES.encryptToBase64(Integer.parseInt(value)+"", ConvertSalaryBill.ENCRYPTKEY));
				break;
			case 6 : salaryBill.setWorkAgeSubsidy(AES.encryptToBase64(Integer.parseInt(value)+"", ConvertSalaryBill.ENCRYPTKEY));
				break;
			case 7 : salaryBill.setTotalDayReward(AES.encryptToBase64(Integer.parseInt(value)+"", ConvertSalaryBill.ENCRYPTKEY));
				break;
			case 8 : salaryBill.setTrafficSubsidy(AES.encryptToBase64(Integer.parseInt(value)+"", ConvertSalaryBill.ENCRYPTKEY));
				break;
			case 9 : salaryBill.setCommunicationSubsidy(AES.encryptToBase64(Integer.parseInt(value)+"", ConvertSalaryBill.ENCRYPTKEY));
				break;
			case 10 : salaryBill.setBirthdaySubsidy(AES.encryptToBase64(Integer.parseInt(value)+"", ConvertSalaryBill.ENCRYPTKEY));
				break;
			case 11 : salaryBill.setBusinessTripSubsidy(AES.encryptToBase64(Integer.parseInt(value)+"", ConvertSalaryBill.ENCRYPTKEY));
				break;
			case 12 : salaryBill.setShouldPayTotal(AES.encryptToBase64(Integer.parseInt(value)+"", ConvertSalaryBill.ENCRYPTKEY));
				break;
			case 13 : salaryBill.setBeLateWithhold(AES.encryptToBase64(Integer.parseInt(value)+"", ConvertSalaryBill.ENCRYPTKEY));
				break;
			case 14 : salaryBill.setEndowmentInsurance(AES.encryptToBase64(Integer.parseInt(value)+"", ConvertSalaryBill.ENCRYPTKEY));
				break;
			case 15 : salaryBill.setMedicalInsurance(AES.encryptToBase64(Integer.parseInt(value)+"", ConvertSalaryBill.ENCRYPTKEY));
				break;
			case 16 : salaryBill.setUnemploymentInsurance(AES.encryptToBase64(Integer.parseInt(value)+"", ConvertSalaryBill.ENCRYPTKEY));
				break;
			case 17 : salaryBill.setHousingProvidentFund(AES.encryptToBase64(Integer.parseInt(value)+"", ConvertSalaryBill.ENCRYPTKEY));
				break;
			case 18 : salaryBill.setBalancePay(AES.encryptToBase64(Integer.parseInt(value)+"", ConvertSalaryBill.ENCRYPTKEY));
				break;
			case 19 : salaryBill.setActuralPayTotal(AES.encryptToBase64(Integer.parseInt(value)+"", ConvertSalaryBill.ENCRYPTKEY));
					break;
			case 20 :salaryBill.setSalaryDate(DateTimeUtils.toDate(value, "yyyy-MM-dd"));
				break;
			case 21 : salaryBill.setRemark(value);
				break;
		}
		return salaryBill;
	}
		
	/**
	 *分割字符转成数组
	 */
	private String[]  getSingleStr(String  str) {
		if(str == null) {
			throw new RuntimeException("发送消息失败");
		}
		return str.split(",");
	}

}
