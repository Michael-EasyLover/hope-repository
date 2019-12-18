package com.hopetech.util;

import java.math.BigDecimal;
import java.net.UnknownHostException;
import java.util.Calendar;

public class SalaryUtil {

	private static BigDecimal SALARY = new BigDecimal("0");
	private static BigDecimal FIVE_ONE = new BigDecimal("3963");
	private static BigDecimal BASE5000 = new BigDecimal("5000");
	//工资起始月
	private static BigDecimal START_MONTH = new BigDecimal("3");
	
	
	public static void main(String[] args) throws UnknownHostException {
		Calendar cal = Calendar.getInstance();
        int monthIndex = cal.get(Calendar.MONTH) + 1;
        
        BigDecimal totalTax = BigDecimal.ZERO;
		for (int i = 4; i <= monthIndex; i++) {
			totalTax = totalTax.add(salaryInThisMonth(i, totalTax));
			System.out.println("=================================");
		}
	}
	
	/**
	 * 
	 * @param month 当前月
	 * @param beforeTaxTotal 之前已扣个税总额
	 */
	private static BigDecimal salaryInThisMonth(int month, BigDecimal beforeTaxTotal) {
		BigDecimal month2Salary = new BigDecimal(2700);
		//本月 数字
		BigDecimal thisMonthIndex = new BigDecimal(month);
		//已工作月数
		BigDecimal months = thisMonthIndex.subtract(START_MONTH);
		
		BigDecimal beforeTax = SALARY.multiply(months).subtract(FIVE_ONE.multiply(months)).subtract(BASE5000.multiply(months.add(new BigDecimal(2)))).add(month2Salary);
		System.out.println(thisMonthIndex + "月发" + thisMonthIndex.subtract(BigDecimal.ONE) + "月工资:");
		System.out.println("计税金额:" + month2Salary+"+"+SALARY+"*"+months+"-"+FIVE_ONE+"*"+months+"-"+BASE5000+"*"+months.add(new BigDecimal(2))+"="+beforeTax);
		
		BigDecimal totalTax = totalTax(beforeTax);
		BigDecimal taxThisMonth = totalTax.subtract(beforeTaxTotal);
		System.out.println("本月缴税:" + totalTax+"-"+beforeTaxTotal+"="+taxThisMonth);
		System.out.println("实发:"+ SALARY+"-"+FIVE_ONE+"-"+BASE5000+"-"+taxThisMonth+"="+SALARY.subtract(FIVE_ONE).subtract(taxThisMonth));
		return taxThisMonth;
	}
	
	private static BigDecimal totalTax(BigDecimal beforeTax) {
		BigDecimal tax = BigDecimal.ZERO;
		BigDecimal taxRate = BigDecimal.ZERO;
		BigDecimal su = BigDecimal.ZERO;
		
		if (beforeTax.doubleValue() <= 36000) {
			taxRate = new BigDecimal("0.03");
		} else if (beforeTax.doubleValue() <= 144000) {
			taxRate = new BigDecimal("0.1");
			su = new BigDecimal(2520);
		} else if (beforeTax.doubleValue() <= 300000) {
			taxRate = new BigDecimal("0.2");
			su = new BigDecimal(16920);
		} else if (beforeTax.doubleValue() <= 420000) {
			taxRate = new BigDecimal("0.25");
			su = new BigDecimal(31920);
		} else if (beforeTax.doubleValue() <= 660000) {
			taxRate = new BigDecimal("0.3");
			su = new BigDecimal(52920);
		} else if (beforeTax.doubleValue() <= 960000) {
			taxRate = new BigDecimal("0.35");
			su = new BigDecimal(85920);
		} else {
			System.out.println("???????????");
			taxRate = new BigDecimal("0.45");
			su = new BigDecimal(181920);
		}
		tax = beforeTax.multiply(taxRate).subtract(su);
		System.out.println(">>>>>>>>>>>累计总税:" + beforeTax+"*"+taxRate+"-"+su+"="+tax);
		return tax;
	}
}
