package com.htcs.wework.salarybill.service.impl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.htcs.wework.common.sec.AES;
import com.htcs.wework.salarybill.dao.SalaryBillDao;
import com.htcs.wework.salarybill.dao.SalaryQuestionDao;
import com.htcs.wework.salarybill.model.SalaryBill;
import com.htcs.wework.salarybill.model.SalaryQuestion;
import com.htcs.wework.salarybill.model.SalaryQuestionQuery;
import com.htcs.wework.salarybill.service.SalaryBillWebService;
import com.htcs.wework.salarybill.util.ConvertSalaryBill;
@Service("salaryBillWebService")
public class SalaryBillWebServiceImpl implements SalaryBillWebService {
	
	@Autowired
	private SalaryBillDao salaryBillDao;
	
	@Autowired
	private  SalaryQuestionDao  salaryquestionDao;
		
	@Autowired
	private JdbcTemplate jdbcTemplate;

	
	public List<Map<String,Object>> listSalarybillsByName(String username) {
		if(username == null || username.length() == 0) {
			throw new RuntimeException("姓名不能为空");
		}
		List<Map<String,Object>>  sortList = new ArrayList<Map<String,Object>>();
		List<Map<String,Object>> list = salaryBillDao.getDatesByName(username);
		for(Map<String,Object> m : list) {
			Map<String,Object> map = new HashMap<String,Object>();
			String date = (String)m.get("salary_date");
			List<SalaryBill> sblist = salaryBillDao.getSalaryBillByName(username, date);
			//Integer actual_total = salaryBillDao.countSalaryBillByName(username, date);
			int actual_total = 0;
			for(SalaryBill s: sblist) {
				actual_total += Integer.parseInt(AES.decryptFromBase64(""+s.getActuralPayTotal(), ConvertSalaryBill.ENCRYPTKEY));
			}
			for(SalaryBill s: sblist) {
				ConvertSalaryBill.convertSalaryBill(s);
			}
			map.put("list", sblist);
			map.put("date", date);
			map.put("total", actual_total);
			sortList.add(map);
		}
		return sortList;
	}

	@Override
	public void addSalarybillQuestion(String  content, String salarybillId, String username, String userId) {
		SalaryQuestion salaryQuestion = new SalaryQuestion();
		SalaryBill salaryBill= new SalaryBill();
		if(content == null || content.length() == 0) {
			throw new RuntimeException("内容不能为空");
		}
		salaryQuestion.setContent(content);
		salaryQuestion.setCreateName(username);
		salaryQuestion.setSalaryBillId(Integer.parseInt(salarybillId));
		salaryQuestion.setUpdateName(username);
		salaryQuestion.setCreateBy(0);
		salaryQuestion.setUpdateBy(0);
		salaryquestionDao.insertSelective(salaryQuestion);
		salaryBill.setProblem((byte)1);
		salaryBill.setId(Integer.parseInt(salarybillId));
		salaryBillDao.updateByPrimaryKeySelective(salaryBill);
	}

	@Override
	public List<SalaryQuestion> listSalarybillQuestionsById(String salarybillId) {
		SalaryQuestionQuery salaryQuestionQuery = new SalaryQuestionQuery();
		salaryQuestionQuery.createCriteria().andSalaryBillIdEqualTo(Integer.parseInt(salarybillId));
		return salaryquestionDao.selectByExample(salaryQuestionQuery);
	}

	@Transactional
	public void updateSalarybillStatusById(String salarybillId) {
		SalaryBill salaryBill = new SalaryBill();
		salaryBill.setStatus(2);
		salaryBill.setId(Integer.parseInt(salarybillId));
		salaryBillDao.updateByPrimaryKeySelective(salaryBill);
	}
	
	
	public List<Map<String,Object>> listTransforms(String salarybillId) {
		String sql = "select id,image from salary_transform where salary_bill_id="+salarybillId;
		List<Map<String,Object>> list = jdbcTemplate.queryForList(sql);
		return list;
	}

	public SalaryBill getSalaryBillById(String salarybillId) {
		SalaryBill salaryBill = salaryBillDao.selectByPrimaryKey(Integer.parseInt(salarybillId));
		ConvertSalaryBill.convertSalaryBill(salaryBill);
		return salaryBill;
	}

}
