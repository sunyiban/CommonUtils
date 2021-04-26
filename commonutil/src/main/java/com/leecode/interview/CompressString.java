package com.leecode.interview;

/**
 * @author sunyiban@panda-fintech.com
 * @title: CompressString
 * @copyright: Copyright (c) 2018
 * @description: 压缩字符串,aabbbbcc -> a2b4c2， 如果压缩后字符串长度大于等于原字符串，返回原字符串
 * aabb -> a2b2 -> aabb <br>
 * @company: panda-fintech
 * @created on 2020/7/11下午9:36
 */
public class CompressString {
  /** 处理错误  aabbaa -> a4b2 正确-》  a2b2a2 */
  public String compressString(String S) {
    if (S.length() < 3) {
      return S;
    }
    // 创建int数组
    int[] words = new int[127];
    // 遍历字符串，根据char获取数组下标，对应值+1
    for (int i = 0; i < S.length(); i++) {
      words[S.charAt(i)] = words[S.charAt(i)] + 1;
    }
    StringBuffer result = new StringBuffer("");
    // 遍历数组，输出下标对应的char和值
    for(int i = 97; i < words.length; i++) {
      if (words[i] == 0) {
        continue;
      }
      result.append((char) i).append(words[i]);
    }
    // 如果字符串大于等于原字符串，输出原字符串
    if (result.length() >= S.length()) {
      return S;
    }
    return result.toString();
  }

  /** 测试通过 */
  public String compressString1(String S) {
    if (S.length() < 3) {
      return S;
    }

    char[] words = S.toCharArray();
    StringBuffer result = new StringBuffer();
    int number = 1;
    char nowWord = words[0];
    for (int i = 1; i < S.length(); i++) {
      if (nowWord != words[i]) {
        // 上一个字符个数
        result.append(nowWord).append(number);
        // number归一
        number = 1;
        // nowWord为当前字符
        nowWord = words[i];
      } else {
        number++;
      }
    }

    // 最后一个字符
    result.append(nowWord).append(number);

    if (result.length() < S.length()) {
      return result.toString();
    }

    return S;
  }

  public static void main(String[] args) {
    CompressString compressString = new CompressString();
    String result =  compressString.compressString1("aabbbbbaa");
    System.out.println(result);
  }
}
