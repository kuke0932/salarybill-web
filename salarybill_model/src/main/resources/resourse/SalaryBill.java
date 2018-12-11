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
    private Integer dutyAttendance;

    /**
     * 实际出勤时间 单位天
     */
    private Integer actualAttendance;

    /**
     * 基础工资 单位分
     */
    private Integer baseSalary;

    /**
     * 提成 单位分
     */
    private Integer percentage;

    /**
     * 工龄补贴 单位分
     */
    private Integer workAgeSubsidy;

    /**
     * 全勤奖 单位分
     */
    private Integer totalDayReward;

    /**
     * 交通补贴 单位分
     */
    private Integer trafficSubsidy;

    /**
     * 通讯补贴 单位分
     */
    private Integer communicationSubsidy;

    /**
     * 生日补贴 单位分
     */
    private Integer birthdaySubsidy;

    /**
     * 出差补助 单位分
     */
    private Integer businessTripSubsidy;

    /**
     * 应发合计 单位分
     */
    private Integer shouldPayTotal;

    /**
     * 迟到扣款 单位分
     */
    private Integer beLateWithhold;

    /**
     * 养老保险 单位分
     */
    private Integer endowmentInsurance;

    /**
     * 医疗保险 单位分
     */
    private Integer medicalInsurance;

    /**
     * 失业保险 单位分
     */
    private Integer unemploymentInsurance;

    /**
     * 住房公积金 单位分
     */
    private Integer housingProvidentFund;

    /**
     * 实发合计
     */
    private Integer acturalPayTotal;

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
    private Integer balancePay;

    /**
     * 已打款
     */
    private Integer alreadyPay;

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

    public Integer getDutyAttendance() {
        return dutyAttendance;
    }

    public void setDutyAttendance(Integer dutyAttendance) {
        this.dutyAttendance = dutyAttendance;
    }

    public Integer getActualAttendance() {
        return actualAttendance;
    }

    public void setActualAttendance(Integer actualAttendance) {
        this.actualAttendance = actualAttendance;
    }

    public Integer getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(Integer baseSalary) {
        this.baseSalary = baseSalary;
    }

    public Integer getPercentage() {
        return percentage;
    }

    public void setPercentage(Integer percentage) {
        this.percentage = percentage;
    }

    public Integer getWorkAgeSubsidy() {
        return workAgeSubsidy;
    }

    public void setWorkAgeSubsidy(Integer workAgeSubsidy) {
        this.workAgeSubsidy = workAgeSubsidy;
    }

    public Integer getTotalDayReward() {
        return totalDayReward;
    }

    public void setTotalDayReward(Integer totalDayReward) {
        this.totalDayReward = totalDayReward;
    }

    public Integer getTrafficSubsidy() {
        return trafficSubsidy;
    }

    public void setTrafficSubsidy(Integer trafficSubsidy) {
        this.trafficSubsidy = trafficSubsidy;
    }

    public Integer getCommunicationSubsidy() {
        return communicationSubsidy;
    }

    public void setCommunicationSubsidy(Integer communicationSubsidy) {
        this.communicationSubsidy = communicationSubsidy;
    }

    public Integer getBirthdaySubsidy() {
        return birthdaySubsidy;
    }

    public void setBirthdaySubsidy(Integer birthdaySubsidy) {
        this.birthdaySubsidy = birthdaySubsidy;
    }

    public Integer getBusinessTripSubsidy() {
        return businessTripSubsidy;
    }

    public void setBusinessTripSubsidy(Integer businessTripSubsidy) {
        this.businessTripSubsidy = businessTripSubsidy;
    }

    public Integer getShouldPayTotal() {
        return shouldPayTotal;
    }

    public void setShouldPayTotal(Integer shouldPayTotal) {
        this.shouldPayTotal = shouldPayTotal;
    }

    public Integer getBeLateWithhold() {
        return beLateWithhold;
    }

    public void setBeLateWithhold(Integer beLateWithhold) {
        this.beLateWithhold = beLateWithhold;
    }

    public Integer getEndowmentInsurance() {
        return endowmentInsurance;
    }

    public void setEndowmentInsurance(Integer endowmentInsurance) {
        this.endowmentInsurance = endowmentInsurance;
    }

    public Integer getMedicalInsurance() {
        return medicalInsurance;
    }

    public void setMedicalInsurance(Integer medicalInsurance) {
        this.medicalInsurance = medicalInsurance;
    }

    public Integer getUnemploymentInsurance() {
        return unemploymentInsurance;
    }

    public void setUnemploymentInsurance(Integer unemploymentInsurance) {
        this.unemploymentInsurance = unemploymentInsurance;
    }

    public Integer getHousingProvidentFund() {
        return housingProvidentFund;
    }

    public void setHousingProvidentFund(Integer housingProvidentFund) {
        this.housingProvidentFund = housingProvidentFund;
    }

    public Integer getActuralPayTotal() {
        return acturalPayTotal;
    }

    public void setActuralPayTotal(Integer acturalPayTotal) {
        this.acturalPayTotal = acturalPayTotal;
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

    public Integer getBalancePay() {
        return balancePay;
    }

    public void setBalancePay(Integer balancePay) {
        this.balancePay = balancePay;
    }

    public Integer getAlreadyPay() {
        return alreadyPay;
    }

    public void setAlreadyPay(Integer alreadyPay) {
        this.alreadyPay = alreadyPay;
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