package com.interview.io;

import org.apache.commons.lang.StringUtils;

import java.io.*;

/**
 * @author sunyiban@panda-fintech.com
 * @title: FileWrite
 * @copyright: Copyright (c) 2018
 * @description: <br>
 * @company: panda-fintech
 * @created on 2019/11/21下午3:17
 */
public class FileWrite {
  public static void main(String[] args) throws Exception {
    File file = new File("/home/sunyiban/test/phone.txt");
    File newFile = new File("/home/sunyiban/test/newphone.txt");
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(newFile)));
    BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));

    int i = 0;
    String line = null;
    while ((line = br.readLine()) != null) {
      if (line.startsWith("+84")) {
        line = line;
      } else if (line.startsWith("0")) {
        line = line.replaceFirst("^0", "+84");
      } else if (line.startsWith("84")) {
        line = line.replaceFirst("84", "+84");
      } else if (StringUtils.isNotBlank(line)) {
        line = "+84" + line;
      }
      bw.write(line);
      bw.newLine();
      if (i == 20000) {
        bw.flush();
      }
      i++;
    }

    bw.flush();
    bw.close();
    br.close();
    System.out.println(i);
  }
}
