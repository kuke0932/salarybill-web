package com.htcs.wework.salarybill.dao;
import org.springframework.stereotype.Repository;
import com.htcs.wework.salarybill.model.SalaryQuestion;
import com.htcs.wework.salarybill.model.SalaryQuestionQuery;
@Repository
public interface SalaryQuestionDao extends SalarybillBaseDao<SalaryQuestion, SalaryQuestionQuery>{
   
}