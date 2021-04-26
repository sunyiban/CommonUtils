package com.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author sunyiban
 * @version V 1.0
 * @Title StringUtil -> Class
 * @Package CommonUtils -> com.util
 * @Description
 * @date 2019/4/19 11:17 
 */
public class StringUtil {
	/**
	 * 剔除字符串中的所有非数字
	 * from: 123aaa23 --> to: 12323
	 *
	 * @author sunyiban
	 * @date 2019/4/19 11:19
	 * @param str
	 * @return java.lang.String
	 */
	public static String getNumberFormString(String str) {
		String regEx = "[^0-9.]";
		Pattern pattern = Pattern.compile(regEx);
		Matcher matcher = pattern.matcher(str);
		return matcher.replaceAll("").trim();
	}

	/**
	 * 剔除字符串中的所有非中文
	 *
	 * @author sunyiban
	 * @date 2019/4/19 11:19
	 * @param str
	 * @return java.lang.String
	 */
	public static String getChineseFromString(String str) {
		String regEx = "[\\u4e00-\\u9fa5]";
		Pattern pattern = Pattern.compile(regEx);
		Matcher matcher = pattern.matcher(str);
		return matcher.replaceAll("").trim();
	}

	/**
	 * 将emoji表情替换成空串
	 *
	 * @param source
	 * @return 过滤后的字符串
	 */
	public static String filterEmoji(String source) {
		if (source != null && source.length() > 0) {
			return source.replaceAll("[\ud800\udc00-\udbff\udfff\ud800-\udfff]", "");
		} else {
			return source;
		}
	}

	public static void main(String[] args) {
		String a = "34.213万美元";
		System.out.println(getNumberFormString(a));

		Map<String, String> map = new HashMap(1);
		map.put("1", "1");
		map.put("2", "2");

		for (Map.Entry<String, String> m : map.entrySet()) {
			System.out.println(m.getKey() + ":" + m.getValue());
		}

		List<String> list = new ArrayList<>(1);
		list.add("1");
		list.add("2");
		System.out.println(list.get(0));
		System.out.println(list.get(1));

	}
}
