package com.htcs.wework.salarybill.util;

/**
 * 对salarybill数据进行加密
 * @author wangyunlong
 *
 */
public class SecuritySalaryBill {
	
	/*public static SalaryBill encodeSalaryBill(SalaryBill salaryBill) {
		// 加密实际出勤天数
		int actualAttendance = salaryBill.getActualAttendance() + convertMiddle(salaryBill.getActualAttendance());
		salaryBill.setActualAttendance(actualAttendance);
		// 加密应出勤天数
		int dutyAttendance = salaryBill.getDutyAttendance() + convertMiddle(salaryBill.getDutyAttendance());
		salaryBill.setDutyAttendance(dutyAttendance);
		// 加密基础工资
		int baseSalary = salaryBill.getBaseSalary() + convertMiddle(salaryBill.getBaseSalary());
		salaryBill.setBaseSalary(baseSalary);
		// 加密提成
		int percentage = salaryBill.getPercentage() + convertMiddle(salaryBill.getPercentage());
		salaryBill.setPercentage(percentage);
		// 加密工龄补贴
		int workAgeSubsidy = salaryBill.getWorkAgeSubsidy() + convertMiddle(salaryBill.getWorkAgeSubsidy());
		salaryBill.setWorkAgeSubsidy(workAgeSubsidy);
		// 加密全勤奖 
		int totalDayReward = salaryBill.getTotalDayReward() + convertMiddle(salaryBill.getTotalDayReward());
		salaryBill.setTotalDayReward(totalDayReward);
		// 加密交通补贴
		int trafficSubsidy = salaryBill.getTrafficSubsidy() + convertMiddle(salaryBill.getTrafficSubsidy());
		salaryBill.setTrafficSubsidy(trafficSubsidy);
		// 加密通讯补贴
		int communicationSubsidy = salaryBill.getCommunicationSubsidy() + convertMiddle(salaryBill.getCommunicationSubsidy());
		salaryBill.setCommunicationSubsidy(communicationSubsidy);
		// 加密生日补贴
		int birthdaySubsidy = salaryBill.getBirthdaySubsidy() + convertMiddle(salaryBill.getBirthdaySubsidy());
		salaryBill.setBirthdaySubsidy(birthdaySubsidy);
		// 加密出差补助
		int businessTripSubsidy = salaryBill.getBusinessTripSubsidy() + convertMiddle(salaryBill.getBusinessTripSubsidy());
		salaryBill.setBusinessTripSubsidy(businessTripSubsidy);
		// 加密应发合计 
		int shouldPayTotal = salaryBill.getShouldPayTotal() + convertMiddle(salaryBill.getShouldPayTotal());
		salaryBill.setShouldPayTotal(shouldPayTotal);
		// 加密迟到扣款
		int beLateWithhold = salaryBill.getBeLateWithhold() + convertMiddle(salaryBill.getBeLateWithhold());
		salaryBill.setBeLateWithhold(beLateWithhold);
		// 加密养老保险
		int endowmentInsurance = salaryBill.getEndowmentInsurance() + convertMiddle(salaryBill.getEndowmentInsurance());
		salaryBill.setEndowmentInsurance(endowmentInsurance);
		// 加密医疗保险 
		int medicalInsurance = salaryBill.getMedicalInsurance() + convertMiddle(salaryBill.getMedicalInsurance());
		salaryBill.setMedicalInsurance(medicalInsurance);
		// 加密失业保险 
		int unemploymentInsurance = salaryBill.getUnemploymentInsurance() + convertMiddle(salaryBill.getUnemploymentInsurance());
		salaryBill.setUnemploymentInsurance(unemploymentInsurance);
		// 加密住房公积金
		int housingProvidentFund = salaryBill.getHousingProvidentFund() + convertMiddle(salaryBill.getHousingProvidentFund());
		salaryBill.setHousingProvidentFund(housingProvidentFund);
		// 加密实发合计
		int acturalPayTotal = salaryBill.getActuralPayTotal() + convertMiddle(salaryBill.getActuralPayTotal());
		salaryBill.setActuralPayTotal(acturalPayTotal);
		// 加密补差
		int balancePay = salaryBill.getBalancePay() + convertMiddle(salaryBill.getBalancePay());
		salaryBill.setBalancePay(balancePay);
		return salaryBill;
	}
	
	public static SalaryBill decodeSalaryBill(SalaryBill salaryBill) {
		// 解密实际出勤天数
		int actualAttendance = salaryBill.getActualAttendance() - convertMiddle(salaryBill.getActualAttendance());
		salaryBill.setActualAttendance(actualAttendance);
		// 解密应出勤天数
		int dutyAttendance = salaryBill.getDutyAttendance() - convertMiddle(salaryBill.getDutyAttendance());
		salaryBill.setDutyAttendance(dutyAttendance);
		// 解密基础工资
		int baseSalary = salaryBill.getBaseSalary() - convertMiddle(salaryBill.getBaseSalary());
		salaryBill.setBaseSalary(baseSalary);
		// 解密提成
		int percentage = salaryBill.getPercentage() - convertMiddle(salaryBill.getPercentage());
		salaryBill.setPercentage(percentage);
		// 解密工龄补贴
		int workAgeSubsidy = salaryBill.getWorkAgeSubsidy() - convertMiddle(salaryBill.getWorkAgeSubsidy());
		salaryBill.setWorkAgeSubsidy(workAgeSubsidy);
		// 解密全勤奖 
		int totalDayReward = salaryBill.getTotalDayReward() - convertMiddle(salaryBill.getTotalDayReward());
		salaryBill.setTotalDayReward(totalDayReward);
		// 解密交通补贴
		int trafficSubsidy = salaryBill.getTrafficSubsidy() - convertMiddle(salaryBill.getTrafficSubsidy());
		salaryBill.setTrafficSubsidy(trafficSubsidy);
		// 解密通讯补贴
		int communicationSubsidy = salaryBill.getCommunicationSubsidy() - convertMiddle(salaryBill.getCommunicationSubsidy());
		salaryBill.setCommunicationSubsidy(communicationSubsidy);
		// 解密生日补贴
		int birthdaySubsidy = salaryBill.getBirthdaySubsidy() + convertMiddle(salaryBill.getBirthdaySubsidy());
		salaryBill.setBirthdaySubsidy(birthdaySubsidy);
		// 解密出差补助
		int businessTripSubsidy = salaryBill.getBusinessTripSubsidy() + convertMiddle(salaryBill.getBusinessTripSubsidy());
		salaryBill.setBusinessTripSubsidy(businessTripSubsidy);
		// 解密应发合计 
		int shouldPayTotal = salaryBill.getShouldPayTotal() - convertMiddle(salaryBill.getShouldPayTotal());
		salaryBill.setShouldPayTotal(shouldPayTotal);
		// 解密迟到扣款
		int beLateWithhold = salaryBill.getBeLateWithhold() - convertMiddle(salaryBill.getBeLateWithhold());
		salaryBill.setBeLateWithhold(beLateWithhold);
		// 解密养老保险
		int endowmentInsurance = salaryBill.getEndowmentInsurance() - convertMiddle(salaryBill.getEndowmentInsurance());
		salaryBill.setEndowmentInsurance(endowmentInsurance);
		// 解密医疗保险 
		int medicalInsurance = salaryBill.getMedicalInsurance() - convertMiddle(salaryBill.getMedicalInsurance());
		salaryBill.setMedicalInsurance(medicalInsurance);
		// 解密失业保险 
		int unemploymentInsurance = salaryBill.getUnemploymentInsurance() - convertMiddle(salaryBill.getUnemploymentInsurance());
		salaryBill.setUnemploymentInsurance(unemploymentInsurance);
		// 解密住房公积金
		int housingProvidentFund = salaryBill.getHousingProvidentFund() - convertMiddle(salaryBill.getHousingProvidentFund());
		salaryBill.setHousingProvidentFund(housingProvidentFund);
		// 解密实发合计
		int acturalPayTotal = salaryBill.getActuralPayTotal() - convertMiddle(salaryBill.getActuralPayTotal());
		salaryBill.setActuralPayTotal(acturalPayTotal);
		// 解密补差
		int balancePay = salaryBill.getBalancePay() - convertMiddle(salaryBill.getBalancePay());
		salaryBill.setBalancePay(balancePay);
		return salaryBill;
	}
	
	private static Integer convertMiddle(Integer money) {
		String strMoney = convertMoneyStr(money);
		return convertStrMoney(strMoney);
	}
	
	private static String convertMoneyStr(Integer money) {
		return String.valueOf(money);
	}
	
	private static Integer convertStrMoney(String money) {
		if(money == null || money.trim().length() == 0 ) {
			return 0;
		}
		String result = "";
		for(int i = 0; i < money.length(); i++) {
			int single = Integer.parseInt(money.charAt(i)+"");
			if(i == 0) {
				result += single;
				continue;
			}
			switch(single) {
				case 0 : result += 1;
					 	break;
				case 1 : result += 5;
						break;
				case 2 : result += 4;
						break;
				case 3 : result += 3;
						break;
				case 4 : result += 2;
						break;
				case 5 : result += 0;
						break;
				case 6 : result += 9;
						break;
				case 7 : result += 8;
						break;
				case 8 : result += 7;
						break;
				case 9 : result += 6;
						break;
				default : break;
			}
		}
		return Integer.parseInt(result);
	}
	
	
	*/
	
	
	
}
