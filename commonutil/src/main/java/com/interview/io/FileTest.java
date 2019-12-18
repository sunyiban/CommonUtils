package com.interview.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author sunyiban@panda-fintech.com
 * @title: FileTest
 * @copyright: Copyright (c) 2018
 * @description: 关于文件类的一些测试 <br>
 * @company: panda-fintech
 * @created on 2019/11/20下午2:53
 */
public class FileTest {

  public static void main(String[] args) throws IOException {
    File file = new File("/tmp/clientlog.txt");
    FileInputStream fis = new FileInputStream(file);
    int len = fis.read();
    System.out.println(len);

    byte[] bytes = new byte[1024];
    len = fis.read(bytes);
    // 这两个值是不相等的
    System.out.println(len == file.length());

    FileOutputStream fos = new FileOutputStream(new File("/tmp/clientlog/test.txt"));
    fos.write(bytes, 0, 10);
    // 写入操作传入的长度参数是左开右闭
    fos.write(bytes, 10, 10);

    fos.close();
  }
}
