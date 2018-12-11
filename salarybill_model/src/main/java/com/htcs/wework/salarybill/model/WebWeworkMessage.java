package com.htcs.wework.salarybill.model;

import java.io.Serializable;

public class WebWeworkMessage implements Serializable {

	private static final long serialVersionUID = -7120692766822260107L;
	
	/**
	 * 员工姓名,暂时没有用到
	 */
	private String touser;
			
	private String content;
	
	/**
	 * 工资清单id
	 */
	private String salarybillIds;
	
	/**
	 * 工资当期日期
	 */
	private String  salaryDates;
	
	/**
	 * 企业微信id
	 */
	private String enterpriseIds;
	
	public WebWeworkMessage() {
		this.content = "当期工资已经保存,请确认！！";
	}

	public String getTouser() {
		return touser;
	}

	public void setTouser(String touser) {
		this.touser = touser;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}	

	public String getSalarybillIds() {
		return salarybillIds;
	}

	public void setSalarybillIds(String salarybillIds) {
		this.salarybillIds = salarybillIds;
	}

	public String getEnterpriseIds() {
		return enterpriseIds;
	}

	public void setEnterpriseIds(String enterpriseIds) {
		this.enterpriseIds = enterpriseIds;
	}

	public String getSalaryDates() {
		return salaryDates;
	}

	public void setSalaryDates(String salaryDates) {
		this.salaryDates = salaryDates;
	}

	@Override
	public String toString() {
		return "WebWeworkMessage [touser=" + touser + ", content=" + content + ", salarybillIds=" + salarybillIds
				+ ", salaryDates=" + salaryDates + ", enterpriseIds=" + enterpriseIds + "]";
	}
	
	
}
