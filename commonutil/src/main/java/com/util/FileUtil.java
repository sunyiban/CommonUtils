package com.util;

import org.apache.axis.encoding.Base64;

import java.io.*;

/**
 * @author sunyiban
 * @version V 1.0
 * @Title FileUtil -> Class
 * @Package CommonUtils -> com.util
 * @Description
 * @date 2019/1/15 11:31 
 */
public class FileUtil {
	public static final byte[] READ_BYTE_1024 = new byte[1024];

	public static String fileToBase64String(File file) throws Exception {
		return Base64.encode(fileToByte(file));
	}

	public static byte[] fileToByte(File file) throws Exception {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		InputStream is = new FileInputStream(file);
		int len;
		while ((len = is.read(READ_BYTE_1024)) > 0) {
			bos.write(READ_BYTE_1024, 0, len);
		}
		return bos.toByteArray();
	}

	public static byte[] fileToByte(File file, byte[] readByte) throws Exception {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		InputStream is = new FileInputStream(file);
		int len;
		while ((len = is.read(readByte)) > 0) {
			bos.write(readByte, 0, len);
		}
		return bos.toByteArray();
	}

	public static void base64StringToFile(File file, String base64String) throws Exception {
		byte[] data = Base64.decode(base64String);
		FileOutputStream fos = new FileOutputStream(file);
		fos.write(data);
	}

	public static void filterBySuffix(File file, String suffix) throws Exception {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File("e:/miss2.txt"))));
		String line = "";
		while ((line = bufferedReader.readLine()) != null) {
			try {
				String str = line.split("\\.")[1];
				if (str.toLowerCase().equals(suffix)) {
					bufferedWriter.write(line + "\n");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		bufferedWriter.flush();
		bufferedWriter.close();
		bufferedReader.close();
	}

	public static void main(String[] args) throws Exception {
		// ↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓测试文件<-->字符串 转换↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓
		File file = new File("e:/miss.txt");
		String result = fileToBase64String(file);
		System.out.println(result);
		File file1 = new File("e:/test.txt");
		base64StringToFile(file1, result);
		System.out.println("finish");
		// ↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑测试文件<-->字符串 转换↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

	}

}
