package com.htcs.wework.salarybill.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class SalaryBill implements Serializable {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 姓名
     */
    private String name;
    
    /**
     * 企业微信id
     */
    private String enterpriseId;

    /**
     * 入职时间
     */
    private Date entryTime;

    /**
     * 应出勤时间 单位天
     */
    private String dutyAttendance;

    /**
     * 实际出勤时间 单位天
     */
    private String actualAttendance;

    /**
     * 基础工资 单位分
     */
    private String baseSalary;

    /**
     * 提成 单位分
     */
    private String percentage;

    /**
     * 工龄补贴 单位分
     */
    private String workAgeSubsidy;

    /**
     * 全勤奖 单位分
     */
    private String totalDayReward;

    /**
     * 交通补贴 单位分
     */
    private String trafficSubsidy;

    /**
     * 通讯补贴 单位分
     */
    private String communicationSubsidy;

    /**
     * 生日补贴 单位分
     */
    private String birthdaySubsidy;

    /**
     * 出差补助 单位分
     */
    private String businessTripSubsidy;

    /**
     * 应发合计 单位分
     */
    private String shouldPayTotal;

    /**
     * 迟到扣款 单位分
     */
    private String beLateWithhold;

    /**
     * 养老保险 单位分
     */
    private String endowmentInsurance;

    /**
     * 医疗保险 单位分
     */
    private String medicalInsurance;

    /**
     * 失业保险 单位分
     */
    private String unemploymentInsurance;

    /**
     * 住房公积金 单位分
     */
    private String housingProvidentFund;

    /**
     * 实发合计
     */
    private String acturalPayTotal;

    /**
     * 工资状态 0已保存 1待确认 2待打款 3已打款
     */
    private Integer status;

    /**
     * 工资日期
     */
    private Date salaryDate;

    /**
     * 备注
     */
    private String remark;

    /**
     * 补差
     */
    private String balancePay;

    /**
     * 已打款
     */
    private String alreadyPay;

    /**
     * 逻辑删除标志
     */
    private Byte logicalDel;

    /**
     * 创建人id
     */
    private Integer createBy;

    /**
     * 创建人姓名
     */
    private String createName;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新人id
     */
    private Integer updateBy;

    /**
     * 更新人名字
     */
    private String updateName;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 0没问题 1有问题
     */
    private Byte problem;
    
    /**
     * 问题集合 
     */
    private List<SalaryQuestion> problems;

    private static final long serialVersionUID = 1L;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Date getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(Date entryTime) {
        this.entryTime = entryTime;
    }

    public String getDutyAttendance() {
        return dutyAttendance;
    }

    public void setDutyAttendance(String dutyAttendance) {
        this.dutyAttendance = dutyAttendance == null ? null : dutyAttendance.trim();
    }

    public String getActualAttendance() {
        return actualAttendance;
    }

    public void setActualAttendance(String actualAttendance) {
        this.actualAttendance = actualAttendance == null ? null : actualAttendance.trim();
    }

    public String getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(String baseSalary) {
        this.baseSalary = baseSalary == null ? null : baseSalary.trim();
    }

    public String getPercentage() {
        return percentage;
    }

    public void setPercentage(String percentage) {
        this.percentage = percentage == null ? null : percentage.trim();
    }

    public String getWorkAgeSubsidy() {
        return workAgeSubsidy;
    }

    public void setWorkAgeSubsidy(String workAgeSubsidy) {
        this.workAgeSubsidy = workAgeSubsidy == null ? null : workAgeSubsidy.trim();
    }

    public String getTotalDayReward() {
        return totalDayReward;
    }

    public void setTotalDayReward(String totalDayReward) {
        this.totalDayReward = totalDayReward == null ? null : totalDayReward.trim();
    }

    public String getTrafficSubsidy() {
        return trafficSubsidy;
    }

    public void setTrafficSubsidy(String trafficSubsidy) {
        this.trafficSubsidy = trafficSubsidy == null ? null : trafficSubsidy.trim();
    }

    public String getCommunicationSubsidy() {
        return communicationSubsidy;
    }

    public void setCommunicationSubsidy(String communicationSubsidy) {
        this.communicationSubsidy = communicationSubsidy == null ? null : communicationSubsidy.trim();
    }

    public String getBirthdaySubsidy() {
        return birthdaySubsidy;
    }

    public void setBirthdaySubsidy(String birthdaySubsidy) {
        this.birthdaySubsidy = birthdaySubsidy == null ? null : birthdaySubsidy.trim();
    }

    public String getBusinessTripSubsidy() {
        return businessTripSubsidy;
    }

    public void setBusinessTripSubsidy(String businessTripSubsidy) {
        this.businessTripSubsidy = businessTripSubsidy == null ? null : businessTripSubsidy.trim();
    }

    public String getShouldPayTotal() {
        return shouldPayTotal;
    }

    public void setShouldPayTotal(String shouldPayTotal) {
        this.shouldPayTotal = shouldPayTotal == null ? null : shouldPayTotal.trim();
    }

    public String getBeLateWithhold() {
        return beLateWithhold;
    }

    public void setBeLateWithhold(String beLateWithhold) {
        this.beLateWithhold = beLateWithhold == null ? null : beLateWithhold.trim();
    }

    public String getEndowmentInsurance() {
        return endowmentInsurance;
    }

    public void setEndowmentInsurance(String endowmentInsurance) {
        this.endowmentInsurance = endowmentInsurance == null ? null : endowmentInsurance.trim();
    }

    public String getMedicalInsurance() {
        return medicalInsurance;
    }

    public void setMedicalInsurance(String medicalInsurance) {
        this.medicalInsurance = medicalInsurance == null ? null : medicalInsurance.trim();
    }

    public String getUnemploymentInsurance() {
        return unemploymentInsurance;
    }

    public void setUnemploymentInsurance(String unemploymentInsurance) {
        this.unemploymentInsurance = unemploymentInsurance == null ? null : unemploymentInsurance.trim();
    }

    public String getHousingProvidentFund() {
        return housingProvidentFund;
    }

    public void setHousingProvidentFund(String housingProvidentFund) {
        this.housingProvidentFund = housingProvidentFund == null ? null : housingProvidentFund.trim();
    }

    public String getActuralPayTotal() {
        return acturalPayTotal;
    }

    public void setActuralPayTotal(String acturalPayTotal) {
        this.acturalPayTotal = acturalPayTotal == null ? null : acturalPayTotal.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getSalaryDate() {
        return salaryDate;
    }

    public void setSalaryDate(Date salaryDate) {
        this.salaryDate = salaryDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getBalancePay() {
        return balancePay;
    }

    public void setBalancePay(String balancePay) {
        this.balancePay = balancePay == null ? null : balancePay.trim();
    }

    public String getAlreadyPay() {
        return alreadyPay;
    }

    public void setAlreadyPay(String alreadyPay) {
        this.alreadyPay = alreadyPay == null ? null : alreadyPay.trim();
    }

    public Byte getLogicalDel() {
        return logicalDel;
    }

    public void setLogicalDel(Byte logicalDel) {
        this.logicalDel = logicalDel;
    }

    public Integer getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName == null ? null : createName.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Integer updateBy) {
        this.updateBy = updateBy;
    }

    public String getUpdateName() {
        return updateName;
    }

    public void setUpdateName(String updateName) {
        this.updateName = updateName == null ? null : updateName.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Byte getProblem() {
        return problem;
    }

    public void setProblem(Byte problem) {
        this.problem = problem;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", entryTime=").append(entryTime);
        sb.append(", dutyAttendance=").append(dutyAttendance);
        sb.append(", actualAttendance=").append(actualAttendance);
        sb.append(", baseSalary=").append(baseSalary);
        sb.append(", percentage=").append(percentage);
        sb.append(", workAgeSubsidy=").append(workAgeSubsidy);
        sb.append(", totalDayReward=").append(totalDayReward);
        sb.append(", trafficSubsidy=").append(trafficSubsidy);
        sb.append(", communicationSubsidy=").append(communicationSubsidy);
        sb.append(", birthdaySubsidy=").append(birthdaySubsidy);
        sb.append(", businessTripSubsidy=").append(businessTripSubsidy);
        sb.append(", shouldPayTotal=").append(shouldPayTotal);
        sb.append(", beLateWithhold=").append(beLateWithhold);
        sb.append(", endowmentInsurance=").append(endowmentInsurance);
        sb.append(", medicalInsurance=").append(medicalInsurance);
        sb.append(", unemploymentInsurance=").append(unemploymentInsurance);
        sb.append(", housingProvidentFund=").append(housingProvidentFund);
        sb.append(", acturalPayTotal=").append(acturalPayTotal);
        sb.append(", status=").append(status);
        sb.append(", salaryDate=").append(salaryDate);
        sb.append(", remark=").append(remark);
        sb.append(", balancePay=").append(balancePay);
        sb.append(", alreadyPay=").append(alreadyPay);
        sb.append(", logicalDel=").append(logicalDel);
        sb.append(", createBy=").append(createBy);
        sb.append(", createName=").append(createName);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateBy=").append(updateBy);
        sb.append(", updateName=").append(updateName);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", problem=").append(problem);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

	public String getEnterpriseId() {
		return enterpriseId;
	}

	public void setEnterpriseId(String enterpriseId) {
		this.enterpriseId = enterpriseId;
	}

	public List<SalaryQuestion> getProblems() {
		return problems;
	}

	public void setProblems(List<SalaryQuestion> problems) {
		this.problems = problems;
	}
}