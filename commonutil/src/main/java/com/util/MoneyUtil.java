package com.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author sunyiban
 * @version V 1.0
 * @Title MoneyUtil -> Class
 * @Package CommonUtils -> com.util
 * @Description 关于金额转换- 阿拉伯数字转中文等
 * @date 2019/4/17 11:11 
 */
public class MoneyUtil {
	// 不考虑分隔符的正确性
	private static final Pattern AMOUNT_PATTERN = Pattern.compile("^(0|[1-9]\\d{0,11})\\.(\\d\\d)$");
	private static final char[] RMB_NUMS = "零壹贰叁肆伍陆柒捌玖".toCharArray();
	private static final String[] UNITS = {"圆", "角", "分", "整"};
	private static final String[] U1 = {"", "拾", "佰", "仟"};
	private static final String[] U2 = {"", "万", "亿"};

	/**
	 * 将金额（整数部分等于或少于12位，小数部分2位）转换为中文大写形式.
	 *
	 * @param amount 金额数字
	 * @return 中文大写
	 * @throws IllegalArgumentException
	 */
	public static String num2Chinese(String amount) throws IllegalArgumentException {
		// 去掉分隔符
		amount = amount.replace(",", "");

		// 验证金额正确性
		if ("0.00".equals(amount)) {
			return "零";
			//	            throw new IllegalArgumentException("金额不能为零.");
		}
		Matcher matcher = AMOUNT_PATTERN.matcher(amount);
		if (!matcher.find()) {
			throw new IllegalArgumentException("输入金额有误.");
		}
		// 整数部分
		String integer = matcher.group(1);
		// 小数部分
		String fraction = matcher.group(2);

		String result = "";
		if (!"0".equals(integer)) {
			// 整数部分
			result += integer2rmb(integer) + UNITS[0];
		}
		if ("00".equals(fraction)) {
			// 添加[整]
			result += UNITS[3];
		} else if (fraction.startsWith("0") && "0".equals(integer)) {
			// 去掉分前面的[零]
			result += fraction2rmb(fraction).substring(1);
		} else {
			// 小数部分
			result += fraction2rmb(fraction);
		}

		return result;
	}

	/**将金额小数部分转换为中文大写*/
	private static String fraction2rmb(String fraction) {
		// 角
		char jiao = fraction.charAt(0);
		// 分
		char fen = fraction.charAt(1);
		return (RMB_NUMS[jiao - '0'] + (jiao > '0' ? UNITS[1] : ""))
				+ (fen > '0' ? RMB_NUMS[fen - '0'] + UNITS[2] : "");
	}

	/**将金额整数部分转换为中文大写*/
	private static String integer2rmb(String integer) {
		StringBuilder buffer = new StringBuilder();
		// 从个位数开始转换
		int i, j;
		for (i = integer.length() - 1, j = 0; i >= 0; i--, j++) {
			char n = integer.charAt(i);
			if (n == '0') {
				// 当n是0且n的右边一位不是0时，插入[零]
				if (i < integer.length() - 1 && integer.charAt(i + 1) != '0') {
					buffer.append(RMB_NUMS[0]);
				}
				// 插入[万]或者[亿]
				if (j % 4 == 0) {
					if (i > 0 && integer.charAt(i - 1) != '0'
							|| i > 1 && integer.charAt(i - 2) != '0'
							|| i > 2 && integer.charAt(i - 3) != '0') {
						buffer.append(U2[j / 4]);
					}
				}
			} else {
				if (j % 4 == 0) {
					// 插入[万]或者[亿]
					buffer.append(U2[j / 4]);
				}
				// 插入[拾]、[佰]或[仟]
				buffer.append(U1[j % 4]);
				// 插入数字
				buffer.append(RMB_NUMS[n - '0']);
			}
		}
		return buffer.reverse().toString();
	}

	public static void main(String[] args) {
		String a = num2Chinese("199991.01");
		System.out.println(a);
	}
}
