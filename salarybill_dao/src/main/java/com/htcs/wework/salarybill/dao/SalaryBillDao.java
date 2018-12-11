package com.htcs.wework.salarybill.dao;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import com.htcs.wework.salarybill.model.SalaryBill;
import com.htcs.wework.salarybill.model.SalaryBillQuery;
@Repository
public interface SalaryBillDao extends SalarybillBaseDao<SalaryBill, SalaryBillQuery> {
   
	List<Map<String,Object>>    getDatesByName(@Param("username") String username);
	
	List<SalaryBill>            getSalaryBillByName(@Param("username") String username, @Param("date") String date);
	
	Integer                     countSalaryBillByName(@Param("username") String username, @Param("date") String date);
	
	List<SalaryBill> 		    getSalaryBillsByCondition(@Param("username") String username ,@Param("status")Integer status,
													@Param("date") String date ,@Param("pageNum")Integer pageNum,@Param("pageSize")Integer pageSize);
	
	Integer                     countSalaryBillsByCondition(@Param("username") String username ,@Param("status")Integer status,
											@Param("date") String date ,@Param("pageNum")Integer pageNum,@Param("pageSize")Integer pageSize);
	
	SalaryBill                  getSalaryByNameAndDate(@Param("username") String username, @Param("date") String date);
	
}