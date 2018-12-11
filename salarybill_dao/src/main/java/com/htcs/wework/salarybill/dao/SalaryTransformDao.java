package com.htcs.wework.salarybill.dao;
import org.springframework.stereotype.Repository;
import com.htcs.wework.salarybill.model.SalaryTransform;
import com.htcs.wework.salarybill.model.SalaryTransformQuery;
@Repository
public interface SalaryTransformDao extends SalarybillBaseDao<SalaryTransform, SalaryTransformQuery> {
	
   
}