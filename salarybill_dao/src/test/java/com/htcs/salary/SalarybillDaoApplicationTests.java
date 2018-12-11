package com.htcs.salary;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.htcs.wework.common.util.DateTimeUtils;
import com.htcs.wework.salarybill.dao.SalaryBillDao;
@RunWith(SpringRunner.class)
@SpringBootTest
public class SalarybillDaoApplicationTests {
	
	@Autowired
	private SalaryBillDao salaryBillDao;
	@Test
	public void test01() {
		List<Map<String,Object>> list = salaryBillDao.getDatesByName("孙悟空");
		for(Map<String,Object> map: list) {
			System.out.println(DateTimeUtils.getTime("yyyy-MM",(Date)map.get("salary_date")));
		}
	}

}
