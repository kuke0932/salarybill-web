package com.htcs.wework.salarybill.util;

import com.htcs.wework.common.sec.AES;
import com.htcs.wework.salarybill.model.SalaryBill;

public class ConvertSalaryBill {
	
	public static String ENCRYPTKEY = "htcsgongzitiaodo";
	
	public static SalaryBill convertSalaryBill(SalaryBill salarybill) {
		salarybill.setActualAttendance(Integer.parseInt(AES.decryptFromBase64(salarybill.getActualAttendance(), ENCRYPTKEY)) + "");
		salarybill.setDutyAttendance(Integer.parseInt(AES.decryptFromBase64(salarybill.getDutyAttendance(), ENCRYPTKEY)) + "");
		salarybill.setBaseSalary(Integer.parseInt(AES.decryptFromBase64(salarybill.getBaseSalary(), ENCRYPTKEY)) + "");
		salarybill.setPercentage(Integer.parseInt(AES.decryptFromBase64(salarybill.getPercentage(), ENCRYPTKEY)) + "");
		salarybill.setWorkAgeSubsidy(Integer.parseInt(AES.decryptFromBase64(salarybill.getWorkAgeSubsidy(), ENCRYPTKEY)) + "");
		salarybill.setTotalDayReward(Integer.parseInt(AES.decryptFromBase64(salarybill.getTotalDayReward(), ENCRYPTKEY)) + "");
		salarybill.setTrafficSubsidy(Integer.parseInt(AES.decryptFromBase64(salarybill.getTrafficSubsidy(), ENCRYPTKEY)) + "");
		salarybill.setCommunicationSubsidy(Integer.parseInt(AES.decryptFromBase64(salarybill.getCommunicationSubsidy(), ENCRYPTKEY)) + "");
		salarybill.setBirthdaySubsidy(Integer.parseInt(AES.decryptFromBase64(salarybill.getBirthdaySubsidy(), ENCRYPTKEY))+"");
		salarybill.setBusinessTripSubsidy(Integer.parseInt(AES.decryptFromBase64(salarybill.getBusinessTripSubsidy(), ENCRYPTKEY)) + "");
		salarybill.setShouldPayTotal(Integer.parseInt(AES.decryptFromBase64(salarybill.getShouldPayTotal(), ENCRYPTKEY)) + "");
		salarybill.setBeLateWithhold(Integer.parseInt(AES.decryptFromBase64(salarybill.getBeLateWithhold(), ENCRYPTKEY)) + "");
		salarybill.setEndowmentInsurance(Integer.parseInt(AES.decryptFromBase64(salarybill.getEndowmentInsurance(), ENCRYPTKEY)) + "");
		salarybill.setMedicalInsurance(Integer.parseInt(AES.decryptFromBase64(salarybill.getMedicalInsurance(), ENCRYPTKEY)) + "");
		salarybill.setUnemploymentInsurance(Integer.parseInt(AES.decryptFromBase64(salarybill.getUnemploymentInsurance(), ENCRYPTKEY)) + "");
		salarybill.setHousingProvidentFund(Integer.parseInt(AES.decryptFromBase64(salarybill.getHousingProvidentFund(), ENCRYPTKEY)) + "");
		salarybill.setActuralPayTotal(Integer.parseInt(AES.decryptFromBase64(salarybill.getActuralPayTotal(), ENCRYPTKEY)) + "");
		salarybill.setBalancePay(Integer.parseInt(AES.decryptFromBase64(salarybill.getBalancePay(), ENCRYPTKEY)) + "");
		if(!"0".equals(salarybill.getAlreadyPay())) {
			salarybill.setAlreadyPay(Integer.parseInt(AES.decryptFromBase64(salarybill.getAlreadyPay(), ENCRYPTKEY)) + "");
		}
		return salarybill;
	}
}
