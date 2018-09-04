package com.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

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

    /**
     * 计算日期天数差，只算天数，忽略时分秒
     * 这个方法提供一个带类型判断的计算日期天数的方法：
     * 开始时间：2018-01-01， 结束时间：2018-01-03
     * 对应类型的计算结果为： 1：2；2：2；3：1；4：3
     *
     * @author sunyiban
     * @date 2018/8/31 11:55
     * @param start 开始时间
     * @param end 结束时间
     * @param type 类型 1 不算开始日，算结束日； 2 算开始日，不算结束日； 3不算开始日，也不算到期日；4 算开始日，也算结束日
     * @return int
     */
    public static int calculateDays(Date start, Date end, Integer type) {
        return calculateDays(formatDate(start, DATE_FORMAT_YYYY_MM_DD), formatDate(end, DATE_FORMAT_YYYY_MM_DD), type);
    }

    /**
     * 计算日期天数差，只算天数，忽略时分秒
     * 这个方法提供一个带类型判断的计算日期天数的方法：
     * 开始时间：2018-01-01， 结束时间：2018-01-03
     * 对应类型的计算结果为： 1：2；2：2；3：1；4：3
     *
     * @author sunyiban
     * @date 2018/8/31 11:55
     * @param start 开始时间 时间格式 yyyy-MM-dd
     * @param end 结束时间 时间格式 yyyy-MM-dd
     * @param type 类型 1不算开始日，也不算到期日；2 算开始日，也算结束日
     * @return int
     */
    public static int calculateDays(String start, String end, Integer type) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_YYYY_MM_DD);
            Date s = sdf.parse(start);
            Date e = sdf.parse(end);
            int days = (int) (e.getTime() - s.getTime()) / (1000 * 60 * 60 * 24);
            if (type != null) {
                if (type == 1) {
                    days = days - 1;
                } else if (type == 2) {
                    days = days + 1;
                }
            }
            return days > 0 ? days : 0;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 计算日期天数差，只算天数，忽略时分秒
     * 这个方法提供一个带类型判断的计算日期天数的方法：
     * 开始时间：2018-01-01， 结束时间：2018-01-03
     * 对应类型的计算结果为：
     * #################
     * #type  | value  #
     * #默认  |   2    #
     * # 1   |    1    #
     * # 2   |    3    #
     * #################
     * @author sunyiban
     * @date 2018/8/31 11:55
     * @param start 开始时间 时间格式 yyyy-MM-dd
     * @param end 结束时间 时间格式 yyyy-MM-dd
     * @return int
     */
    public static int calculateDays(String start, String end) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_YYYY_MM_DD);
            Date s = sdf.parse(start);
            Date e = sdf.parse(end);
            int days = (int) (e.getTime() - s.getTime()) / (1000 * 60 * 60 * 24);
            return days > 0 ? days : 0;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }

	public static void main(String[] args) {
    	Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, 1);
		System.out.println(new SimpleDateFormat(DATE_FORMAT_YYYY_MM_DD).format(cal.getTime()));

		cal.add(Calendar.DAY_OF_MONTH, 50);
		System.out.println(new SimpleDateFormat(DATE_FORMAT_YYYY_MM_DD).format(cal.getTime()));

		cal.add(Calendar.MONTH, 3);
		System.out.println(new SimpleDateFormat(DATE_FORMAT_YYYY_MM_DD).format(cal.getTime()));

		cal.add(Calendar.MONTH, 2);
		System.out.println(new SimpleDateFormat(DATE_FORMAT_YYYY_MM_DD).format(cal.getTime()));


		//↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓这是一个关于iterater删除元素原理的验证↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓
		List<String> list = new ArrayList<String>();
		list.add("123");
		list.add("234");
		list.add("345");
		list.add("456");
		Iterator<String> iterator = list.iterator();
		while(iterator.hasNext()) {
			String a = iterator.next();
			System.out.println(a + ":" + list.indexOf(a));
			/**
			 * 源码解析：
			 *      这是重写的ITERATOR删除方法
			 * 		public void remove() {
			 *             if (this.lastRet < 0) {
			 *                 throw new IllegalStateException();
			 *             } else {
			 *                 this.checkForComodification();
			 *
			 *                 try {
			 *                 		第一步，这里调用了ARRAYLIST的删除方法
			 *                     ArrayList.this.remove(this.lastRet);
			 *                     第二步，将删除的元素的位置给了游标，这里就是为什么iteratre方法能准确删除元素的关键
			 *                     相对于普通的for循环，我们删除后并没有将指针定位，所以普通的for循环内删除就会出现135。。
			 *                     这种隔代删除的情况
			 *                     this.cursor = this.lastRet;
			 *                     第三步，重置了删除的变量
			 *                     this.lastRet = -1;
			 *                     第四步，将操作结果给预期结果
			 *                     this.expectedModCount = ArrayList.this.modCount;
			 *                 } catch (IndexOutOfBoundsException var2) {
			 *                     throw new ConcurrentModificationException();
			 *                 }
			 *             }
			 *         }
			 *
			 * 		这是ARRAYLIST类的删除方法
			 * 		public E remove(int var1) {
			 *         this.rangeCheck(var1);
			 *         ++this.modCount;
			 *         Object var2 = this.elementData(var1);
			 *         int var3 = this.size - var1 - 1;
			 *         if (var3 > 0) {
			 *         	   如果删除的不是最后一个元素，就会复制一个数组出来
			 *             System.arraycopy(this.elementData, var1 + 1, this.elementData, var1, var3);
			 *         }
			 *         然后将数组大小-1
			 *         this.elementData[--this.size] = null;
			 *         return var2;
			 *     }
			 */
			iterator.remove();
		}
		for (String li : list) {
			System.out.print(li + ":");
		}

		System.out.println("===========================================");

		List<String> list1 = new ArrayList<String>();
		list1.add("123");
		list1.add("234");
		list1.add("345");
		list1.add("456");
		for (int i = 0; i < list1.size(); i++) {
			list1.remove(i);
		}
		for (String li : list1) {
			System.out.print(li + ":");
		}
		//↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑这是一个关于iterater删除元素原理的验证↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑
	}

}
