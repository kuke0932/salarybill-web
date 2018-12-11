package com.htcs.wework.salarybill.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import me.chanjar.weixin.cp.api.WxCpService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SalarybillWebApplicationTests {
	
	@Autowired
	private WxCpService wxCpService;
	
	@Test
	public void contextLoads() {
		String str = wxCpService.getOauth2Service().buildAuthorizationUrl("http://salarybill.hbwrrj.com/salarybill/web/salarybill/getUserInfo","state");
		System.out.println(str);
	}
	
}
