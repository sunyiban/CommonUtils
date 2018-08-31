package com.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author sunyiban
 * @version V 1.0
 * @Title DateUtil -> Class
 * @Package CommonUtils -> com.util
 * @Description This util contain get set time, calculate days between tow date and so on.
 * @date 2018/8/31 11:40
 */
public class DateUtil {

    public static final String DATE_FORMAT_YYYY = "yyyy";
    public static final String DATE_FORMAT_YYYY_MM = "yyyy-MM";
    public static final String DATE_FORMAT_YYYY_MM_DD = "yyyy-MM-dd";

    /**
     * 获取指定格式的当前日期字符串
     *
     * @author sunyiban
     * @date 2018/8/31 11:46
     * @param dateFormat 日期格式化类型 DateUtil.DATE_
     * @return java.lang.String 格式化后的日期，如果报错，返回空字符串
     */
    public static String getNowDateStr(String dateFormat) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
            return sdf.format(new Date());
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /**
     * 格式化日期
     *
     * @author sunyiban
     * @date 2018/8/31 11:48
     * @param date 日期，如果为null则默认为当前时间
     * @param dateFormat 格式
     * @return java.lang.String 格式化后的日期
     */
    public static String formatDate(Date date, String dateFormat) {
        try {
            if (date == null) {
                date = new Date();
            }
            SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
            return sdf.format(date);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

}
