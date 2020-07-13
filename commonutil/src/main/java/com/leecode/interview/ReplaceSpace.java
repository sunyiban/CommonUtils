package com.leecode.interview;

/**
 * @author sunyiban@panda-fintech.com
 * @title: ReplaceSpace
 * @copyright: Copyright (c) 2018
 * @description: <br>
 * @company: panda-fintech
 * @created on 2020/7/2下午5:47
 */
public class ReplaceSpace {
  public String replaceSpace(String S, int length) {
    if (!S.contains(" ")) {
      return S;
    }

    if (S.length() != length) {
      S = S.substring(0, length);
    }

    return S.replaceAll(" ", "%2B");
  }
}
