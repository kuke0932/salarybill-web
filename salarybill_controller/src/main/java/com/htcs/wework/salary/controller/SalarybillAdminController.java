package com.htcs.wework.salary.controller;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.htcs.wework.common.bean.ReturnStatus;
import com.htcs.wework.common.conf.RequestUserHolder;
import com.htcs.wework.common.model.LoginSysUser;
import com.htcs.wework.salarybill.model.WebWeworkMessage;
import com.htcs.wework.salarybill.service.SalaryBillAdminService;
@RestController
@RequestMapping("/admin/salarybill")
public class SalarybillAdminController {

	@Autowired
	private SalaryBillAdminService	salaryBillAdminService;
	
	/**
	 * 条件查询工资清单
	 * @param username
	 * @param status
	 * @param salaryDate
	 * @param pageNum
	 * @param pageSize
	 * @return2018年5月9日wangyunlong
	 */
	@GetMapping("/listSalaryBillsByCondition")
	public ReturnStatus<Map<String,Object>> listSalaryBillsByCondition(String username,
								Integer status, String salaryDate, Integer pageNum, Integer pageSize) {
		return new ReturnStatus<>(salaryBillAdminService.listSalaryBillsByCondition(username,status,salaryDate,pageNum,pageSize));
	}
	
	/**
	 * 添加收据凭证，并发送通知
	 * @param salaryTransforms
	 * @return2018年5月9日wangyunlong
	 */
	@PostMapping("/addSalaryTransforms")
	public ReturnStatus addSalaryTransforms(MultipartFile file, String money, String salarybillId, String salaryDate, String enterpriseId, HttpServletRequest  request) {
		LoginSysUser user = RequestUserHolder.currentSysUser();
		salaryBillAdminService.addSalaryTransforms(file,money,salarybillId,salaryDate,enterpriseId,user);
		return new ReturnStatus("添加成功");
	}
	
	/**
	 * 打款后，向系统发送通知
	 * @param webChatMessage
	 * @return2018年5月9日wangyunlong
	 */
	@PostMapping("/sendWebChatMessage")
	public ReturnStatus sendWebChatMessage(WebWeworkMessage webChatMessage, HttpServletRequest  request) {
		LoginSysUser user = RequestUserHolder.currentSysUser();
		salaryBillAdminService.sendWebChatMessage(webChatMessage,user);
		return new ReturnStatus("发送成功");
	}
	
	/**
	 * 解析Excel,添加工资清单
	 * @param file
	 * @param username
	 * @param sheetname
	 * @return2018年5月9日wangyunlong
	 */
	@PostMapping("/addSalaryBills")
	public ReturnStatus addSalaryBills(MultipartFile file, HttpServletRequest  request) {
		LoginSysUser user = RequestUserHolder.currentSysUser();
		salaryBillAdminService.addSalaryBills(file,user);
		return new ReturnStatus("添加成功");
	}
	
	
	
	
	
	
	
	
	
}
