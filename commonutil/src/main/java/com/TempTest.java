package com;

import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
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
    LinkedList<String> linkedList = new LinkedList<>();
    Collections.reverse(linkedList);
  }


}
