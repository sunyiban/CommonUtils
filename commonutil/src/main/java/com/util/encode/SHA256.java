package com.util.encode;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author sunyiban
 * @version V 1.0
 * @Title SHA256 -> Class
 * @Package CommonUtils -> com.util.encode
 * @Description
 * @date 2018/11/28 10:44 
 */
public class SHA256 {
	public static String getSHA256(String input) throws NoSuchAlgorithmException, UnsupportedEncodingException
	{
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		md.update(input.getBytes(Charset.forName("UTF-8")));
		byte byteData[] = md.digest();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < byteData.length; i++) {
			sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
		}
		return sb.toString();
	}

	public static void main(String[] args) throws Exception {
		System.out.println(getSHA256("张文370103199909092513"));
	}
}
