package com.htcs.wework.salarybill.dao;
import org.springframework.stereotype.Repository;
import com.htcs.wework.salarybill.model.SalaryEnterpriseId;
import com.htcs.wework.salarybill.model.SalaryEnterpriseIdQuery;
@Repository
public interface SalaryEnterpriseIdDao extends  SalarybillBaseDao<SalaryEnterpriseId, SalaryEnterpriseIdQuery> {
   
}