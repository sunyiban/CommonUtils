package com.leecode.interview;

import java.util.Arrays;

/**
 * @author sunyiban@panda-fintech.com
 * @title: UniqueSolution
 * @copyright: Copyright (c) 2018
 * @description: <br> 判断字符串中字符是否唯一
 * @company: panda-fintech
 * @created on 2020/6/5上午9:43
 */
public class UniqueSolution {
  public static boolean isUnique(String word) {
    if (word.length() <= 0 || word.length() >= 100) {
      return false;
    }

    word = word.replaceAll("\"", "");
    char[] chars = word.toCharArray();
    Arrays.sort(chars);
    boolean flag = true;
    char nowWord = chars[0];
    for (int i = 1; i < chars.length; i++) {
      if (nowWord == chars[i]) {
        flag = false;
        break;
      } else {
        nowWord = chars[i];
      }
    }
    return flag;
  }

  public static void main(String[] args) {
    String a = "abcsskak";
    System.out.println(isUnique(a));
    System.out.println("standard:" + standardSolution(a));

    String b = "abcdefghijklmn";
    System.out.println(isUnique(b));
    System.out.println("standard:" + standardSolution(b));

    System.out.println(Integer.toBinaryString(64));
  }

  public static boolean standardSolution(String word) {

    // 第一种方式
    for (int i = 0; i < word.length(); i++) {
      if (word.indexOf(word.charAt(i), i+1) != -1) {
        return false;
      }
    }

    // 第二种方式
//    for (char c : word.toCharArray()) {
//      System.out.println(word.indexOf(c) + ":" + word.lastIndexOf(c));
//      if (word.indexOf(c) != word.lastIndexOf(c)) {
//        return false;
//      }
//    }

    return true;
  }
}
