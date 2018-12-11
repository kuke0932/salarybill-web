package com.htcs.wework.salarybill.service;
import java.util.List;
import java.util.Map;

import com.htcs.wework.salarybill.model.SalaryBill;
import com.htcs.wework.salarybill.model.SalaryQuestion;
public interface SalaryBillWebService {
		
	List<Map<String,Object>>    listSalarybillsByName(String username);
	
	void                 		addSalarybillQuestion(String  content,String salarybillId,String username,String userId);
	
	List<SalaryQuestion> 		listSalarybillQuestionsById(String salarybillId);
	
	void    			  		updateSalarybillStatusById(String salarybillId);
	
	List<Map<String,Object>> 	listTransforms(String salarybillId);
	
	SalaryBill             		getSalaryBillById(String salarybillId);
}
