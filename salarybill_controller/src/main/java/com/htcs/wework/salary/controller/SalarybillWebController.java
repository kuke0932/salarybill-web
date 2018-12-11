package com.htcs.wework.salary.controller;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.htcs.wework.common.CacheConstans;
import com.htcs.wework.common.bean.ReturnStatus;
import com.htcs.wework.common.conf.RequestUserHolder;
import com.htcs.wework.common.model.LoginWebUser;
import com.htcs.wework.common.util.cache.CacheUtils;
import com.htcs.wework.common.util.token.JWTokenUtils;
import com.htcs.wework.salarybill.model.SalaryBill;
import com.htcs.wework.salarybill.model.SalaryQuestion;
import com.htcs.wework.salarybill.service.SalaryBillWebService;

import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.cp.api.WxCpService;
import me.chanjar.weixin.cp.api.WxCpUserService;
import me.chanjar.weixin.cp.bean.WxCpUser;

@Controller
@RequestMapping("/web/salarybill")
public class SalarybillWebController {

	@Autowired
	private SalaryBillWebService salaryBillWebService;

	@Autowired
	private WxCpService wxCpService;

	@Autowired
	private WxCpUserService wxCpUserService;

	/**
	 * 根据姓名查询个人工资清单
	 * 
	 * @param pageNum
	 * @param pageSize
	 * @return2018年5月9日wangyunlong
	 */
	@GetMapping("/listSalarybillsByName")
	@ResponseBody
	public ReturnStatus<List<Map<String, Object>>> listSalarybillsByName(HttpServletRequest request) {
		WxCpUser user = RequestUserHolder.currentWebUser();
		System.out.println(user);
		return new ReturnStatus<>(salaryBillWebService.listSalarybillsByName(user.getName()));
	}

	/**
	 * 员工提出问题
	 * 
	 * @param content
	 * @param salarybillId
	 * @return2018年5月9日wangyunlong
	 */
	@PostMapping("/addSalarybillQuestion")
	@ResponseBody
	public ReturnStatus addSalarybillQuestion(HttpServletRequest request, String content, String salarybillId) {
		WxCpUser user = RequestUserHolder.currentWebUser();
		salaryBillWebService.addSalarybillQuestion(content, salarybillId, user.getName(),user.getUserId());
		return new ReturnStatus("添加成功");
	}

	/**
	 * 查看工资清单问题
	 * 
	 * @param salarybillId
	 * @return2018年5月9日wangyunlong
	 */
	@GetMapping("/listSalarybillQuestionsById")
	@ResponseBody
	public ReturnStatus<List<SalaryQuestion>> listSalarybillQuestionsById(String salarybillId) {
		List<SalaryQuestion> list = salaryBillWebService.listSalarybillQuestionsById(salarybillId);
		return new ReturnStatus<>(list);
	}

	/**
	 * 确认该工资清单没有问题
	 * 
	 * @param salarybillId
	 * @return2018年5月9日wangyunlong
	 */
	@PostMapping("/updateSalarybillStatusById")
	@ResponseBody
	public ReturnStatus updateSalarybillStatusById(String salarybillId) {
		salaryBillWebService.updateSalarybillStatusById(salarybillId);
		return new ReturnStatus("确认成功");
	}

	/**
	 * 获取凭证图片
	 * 
	 * @param salarybillId
	 * @return2018年5月9日wangyunlong
	 */
	@GetMapping("/listTransforms")
	@ResponseBody
	public ReturnStatus<List<String>> listTransforms(String salarybillId, HttpServletResponse response) {
		List<Map<String, Object>> list = salaryBillWebService.listTransforms(salarybillId);
		List<String> images = new ArrayList<String>();
		for (Map<String, Object> map : list) {
			String encoded = Base64.getEncoder().encodeToString((byte[]) map.get("image"));
			images.add(encoded);
		}
		return new ReturnStatus<List<String>>(images);
	}

	/**
	 * 企业微信认证
	 * 
	 * @param request
	 * @param code
	 * @param state
	 * @throws WxErrorException 
	 * @return2018年5月10日wangyunlong
	 */
	@GetMapping("/getUserInfo")
	public String getUserInfo(HttpServletRequest request, String code, String state) throws WxErrorException {
		String[] res = null;
		res = wxCpService.getOauth2Service().getUserInfo(code);
		String userId = res[0];
		WxCpUser user = null;	
		user = wxCpUserService.getById(userId);
		String userKey = user.getName() + ".web";
		String token = JWTokenUtils.createToken(userKey);
		LoginWebUser loginWebUser = new LoginWebUser();
		BeanUtils.copyProperties(user, loginWebUser);
		CacheUtils.getInstance(CacheUtils.CacheType.REDIS).put(CacheConstans.WEB_CACHE, userKey, loginWebUser, 60,
				TimeUnit.MINUTES);
		return "redirect:http://salarybill.hbwrrj.com?x=" + token;
	}
	
	@GetMapping("/getUserInfoMessage")
	public String getUserInfoMessage(HttpServletRequest request, String code, String state) throws WxErrorException {
		String[] res = null;
		res = wxCpService.getOauth2Service().getUserInfo(code);
		String userId = res[0];
		WxCpUser user = null;	
		user = wxCpUserService.getById(userId);
		String userKey = user.getName() + ".web";
		String token = JWTokenUtils.createToken(userKey);
		LoginWebUser loginWebUser = new LoginWebUser();
		BeanUtils.copyProperties(user, loginWebUser);
		CacheUtils.getInstance(CacheUtils.CacheType.REDIS).put(CacheConstans.WEB_CACHE, userKey, loginWebUser, 60,
				TimeUnit.MINUTES);
		return "redirect:http://salarybill.hbwrrj.com/salary/details?x=" + token+"&id="+state;
	}

	/**
	 * 企业微信认证,仅用来测试
	 * 
	 * @param request
	 * @param code
	 * @param state
	 * @return2018年5月10日wangyunlong
	 */
	@GetMapping("/getUserInfoLocal")
	public String getUserInfoLocal(HttpServletRequest request, String code, String state) {
		WxCpUser user = new WxCpUser();
		user.setName("王云龙");
		user.setUserId("WangYunLong");
		String userKey = user.getName() + ".web";
		String token = JWTokenUtils.createToken(userKey);
		LoginWebUser loginWebUser = new LoginWebUser();
		BeanUtils.copyProperties(user, loginWebUser);
		CacheUtils.getInstance(CacheUtils.CacheType.REDIS).put(CacheConstans.WEB_CACHE, userKey, loginWebUser, 60,
				TimeUnit.MINUTES);
		return "redirect:http://10.0.0.39?x=" + token;
	}
	
	/**
	 * 根据salaryId获得工资条
	 * @param salarybillId
	 */
	@PostMapping("/getSalarybillById")
	@ResponseBody
	public ReturnStatus<SalaryBill> getSalaryBillById(String salarybillId) {
		SalaryBill salarybill = salaryBillWebService.getSalaryBillById(salarybillId);
		return new ReturnStatus<SalaryBill>(salarybill);
	}
}
