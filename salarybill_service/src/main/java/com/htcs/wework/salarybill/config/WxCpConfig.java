package com.htcs.wework.salarybill.config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import me.chanjar.weixin.cp.api.WxCpService;
import me.chanjar.weixin.cp.api.WxCpUserService;
import me.chanjar.weixin.cp.api.impl.WxCpServiceImpl;
import me.chanjar.weixin.cp.api.impl.WxCpUserServiceImpl;
import me.chanjar.weixin.cp.config.WxCpInMemoryConfigStorage;
@Configuration
public class WxCpConfig {
	
	@Value("${enterprise.agentId}")
	private String agentId;
	
	@Value("${enterprise.corpid}")
	private String corpid;
	
	@Value("${enterprise.corpsecret}")
	private String corpsecret;
	/**
	 * 企业微信工具
	 * @return2018年5月10日wangyunlong
	 */
	@Bean
	public WxCpInMemoryConfigStorage getWxCpInMemoryConfigStorage() {
		WxCpInMemoryConfigStorage config = new WxCpInMemoryConfigStorage();
		config.setAgentId(Integer.parseInt(agentId));
		config.setCorpId(corpid);
		config.setCorpSecret(corpsecret);
		return config;
	}
	
	@Bean
	public  WxCpService getWxCpService(WxCpInMemoryConfigStorage config) {
		WxCpService wxCpService = new WxCpServiceImpl();
		wxCpService.setWxCpConfigStorage(config);
		return  wxCpService;
	}
	
	@Bean 
	public WxCpUserService   getWxCpUser(WxCpService wxCpService) {
		return new WxCpUserServiceImpl(wxCpService);
	}
	
	
	
}
