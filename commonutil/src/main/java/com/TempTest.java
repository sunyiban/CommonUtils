package com;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author sunyiban@panda-fintech.com
 * @title: TempTest
 * @copyright: Copyright (c) 2018
 * @description: <br>
 * @company: panda-fintech
 * @created on 2019/11/22上午9:57
 */
public class TempTest {

  static int a;
    static Matcher matcher = Pattern.compile("^\\d*").matcher("123");

  public static void main(String[] args) throws IOException {
//    System.out.println(matcher.matches());
//    System.out.println(4 & 5);
//    System.out.println(4 | 5);
//    System.out.println(4 ^ 5);sout

//    System.out.println(Integer.toBinaryString(4));
//    System.out.println(Integer.toBinaryString(5));
//    System.out.println(Integer.toBinaryString(6));

//    System.out.println(22 & 1);
//    System.out.println(23 & 1);
//    System.out.println(24&1);
//    System.out.println(25&1);
//
//    System.out.println(Pattern.matches("\\d+", "123"));

//
//    String regex = "[*\\-+/]";
//
//    System.out.println(regex.subSequence(0,5));
//    Pattern pattern = Pattern.compile(regex);
//    String[] strs = pattern.split("123[123*234-345+456/567", 2);
//    for(String s : strs) {
//      System.out.println(s);
//    }

    System.out.println(Integer.toBinaryString(4));
    System.out.println(Integer.toBinaryString(-4));
    System.out.println(-4>>>2);
    System.out.println(-4>>>4);
    System.out.println(-4>>>6);


  }


}
