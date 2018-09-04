package com.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * @author sunyiban
 * @version V 1.0
 * @Title DecimalUtil -> Class
 * @Package CommonUtils -> com.util
 * @Description 关于数值的工具类，包装了一些简单的运算和格式化功能
 * @date 2018/9/4 16:02 
 */
public class DecimalUtil {

	/**千分位，保留两位小数，不足补零*/
	public static final DecimalFormat FORMAT_MONEY_THOUSANDS_SCALE_TOW = new DecimalFormat("#,##0.00");
	/**千分位，保留四位小数，不足补零*/
	public static final DecimalFormat FORMAT_MONEY_THOUSANDS_SCALE_FOUR = new DecimalFormat("#,##0.0000");
	/**100*/
	public static final BigDecimal ONE_HUNDRED = new BigDecimal("100");
	/**百分号*/
	public static final String PERCENT = "%";

	/**
	 * 计算所占百分比，保留两位小数，四舍五入
	 * dividend / divisor * 100
	 *
	 * @author sunyiban
	 * @date 2018/9/4 16:09
	 * @param dividend 被除数
	 * @param divisor 除数 如果为null或者0 默认当做100来计算
	 * @return java.lang.String n%
	 */
	public static String getRate(BigDecimal dividend, BigDecimal divisor) {
		if (dividend == null) {
			return "";
		}
		if (divisor == null || BigDecimal.ZERO.compareTo(divisor) == 0) {
			return getRate(dividend);
		}
		BigDecimal result = dividend.multiply(ONE_HUNDRED).divide(divisor, 2, BigDecimal.ROUND_HALF_UP);
		return result.toString() + PERCENT;
	}

	/**
	 * 计算所占百分比，保留两位小数
	 * dividend / 100
	 *
	 * @author sunyiban
	 * @date 2018/9/4 16:09
	 * @param dividend 被除数
	 * @return java.lang.String n%
	 */
	public static String getRate(BigDecimal dividend) {
		BigDecimal result = dividend.divide(ONE_HUNDRED, 2, BigDecimal.ROUND_HALF_UP);
		return result.toString() + PERCENT;
	}

	/**
	 * 格式化为千分位两位小数
	 *
	 * @author sunyiban
	 * @date 2018/9/4 16:19
	 * @param number 需要格式化的数字
	 * @return java.lang.String
	 */
	public static String formatThoundsAndScaleTwo(BigDecimal number) {
		if (number == null) {
			return "";
		}
		return FORMAT_MONEY_THOUSANDS_SCALE_TOW.format(number);
	}

	/**
	 * 格式化为千分位四位小数
	 *
	 * @author sunyiban
	 * @date 2018/9/4 16:19
	 * @param number 需要格式化的数字
	 * @return java.lang.String
	 */
	public static String formatThoundsAndScaleFour(BigDecimal number) {
		if (number == null) {
			return "";
		}
		return FORMAT_MONEY_THOUSANDS_SCALE_FOUR.format(number);
	}

	public static void main(String[] args) {
		BigDecimal testNumber = new BigDecimal("66.666");
		System.out.println(getRate(new BigDecimal("1"), new BigDecimal("0")));
		System.out.println(getRate(new BigDecimal("33"), new BigDecimal("100")));
		System.out.println(getRate(new BigDecimal("88"), new BigDecimal("1000")));

		System.out.println(formatThoundsAndScaleTwo(testNumber));
		System.out.println(formatThoundsAndScaleFour(testNumber));
	}
}
