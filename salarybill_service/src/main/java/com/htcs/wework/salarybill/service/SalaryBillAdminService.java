package com.htcs.wework.salarybill.service;
import java.util.Map;
import org.springframework.web.multipart.MultipartFile;
import com.htcs.wework.common.model.LoginSysUser;
import com.htcs.wework.salarybill.model.WebWeworkMessage;
public interface SalaryBillAdminService {
	
	Map<String,Object>         listSalaryBillsByCondition(String username,
														Integer status,
														String salaryDate,
														int pageNum,
														int pageSize);
	
	void 					 addSalaryTransforms(MultipartFile file, String money, String salarybillId, String salaryDate, String enterpriseId, LoginSysUser  user);
	
	void					 sendWebChatMessage(WebWeworkMessage webChatMessage, LoginSysUser  user);
	
	void 					 addSalaryBills(MultipartFile file, LoginSysUser  user);
	
	
}
