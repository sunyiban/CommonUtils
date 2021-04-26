package com.interview.base;

import java.io.*;

/**
 * @author sunyiban@panda-fintech.com
 * @title: BytesTest
 * @copyright: Copyright (c) 2018
 * @description: 关于字符大小和文件大小的测试<br>
 * @company: panda-fintech
 * @created on 2019/11/21上午9:39
 */
public class BytesTest {
  public static void main(String[] args) {
    String a = "a123a张";

    byte[] b = a.getBytes();
    // 8字节，表示一个汉字三字节，字符各一字节
    System.out.println(b.length);
    for (byte y : b) {
      System.out.print(y + ": ");
    }

    // 创建一个文件试试
    File file = new File("/home/sunyiban/test/bytes.txt");
    try (FileOutputStream fos = new FileOutputStream(file)) {
      fos.write(b);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    // 文件长度和写入一致
    System.out.println("\nfilelength: " + file.length());

    // 输出文件内容，也是一致的
    try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {
      System.out.println(br.readLine());
    } catch (IOException e) {
      e.printStackTrace();
    }

  }
}
