package com.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author sunyiban
 * @version V 1.0
 * @Title CalendarUtil -> Class
 * @Package CommonUtils -> com.util
 * @Description 关于Calendar的理解和工具类
 * @date 2018/10/31 11:25 
 */
public class CalendarUtil {

	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:ss:mm");

	public static int getYear(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.YEAR);
	}

	public static int getDay(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.DAY_OF_MONTH);
	}

	public static int getHour(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.HOUR_OF_DAY);
	}

	public static int getMinute(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.MINUTE);
	}

	public static int getSecond(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.SECOND);
	}

	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();
		System.out.println(sdf.format(calendar.getTime()));

		Date date = new Date();
		calendar.setTime(date);
		System.out.println(sdf.format(calendar.getTime()));

		calendar.add(Calendar.DAY_OF_MONTH, -1);
		System.out.println(sdf.format(calendar.getTime()));

		calendar.add(Calendar.MONTH, 2);
		System.out.println(sdf.format(calendar.getTime()));

		subDate(calendar);
		System.out.println(sdf.format(calendar.getTime()));
	}

	private static void subDate(Calendar calendar) {
		calendar.add(Calendar.YEAR, -1);
	}


}
