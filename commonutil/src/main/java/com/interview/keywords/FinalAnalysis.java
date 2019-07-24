package com.interview.keywords;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sunyiban
 * @version V 1.0
 * @Title FinalAnalysis -> Class
 * @Package CommonUtils -> com.interview.keywords
 * @Description
 * @date 2019/5/22 15:22 
 */
public class FinalAnalysis {

	static final List<String> list = new ArrayList<>();

	static final String str = "hello";

	static final StringBuilder sb = new StringBuilder("");

	public static void main(String[] args) {
		list.add("a");
		list.add("b");
		for (String a : list) {
			System.out.println(a);
		}

		sb.append("1");
		System.out.println(sb.toString());
	}

}
