package com.util;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;

import javax.net.ssl.*;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.util.Iterator;
import java.util.Map;

/**
 * @author sunyiban
 * @version V 1.0
 * @Title HttpUtil -> Class
 * @Package CommonUtils -> com.util
 * @Description
 * @date 2018/9/1 10:08
 */
public class HttpUtil {
    public static String post(String url, Map<String, Object> params) throws Exception{
		/*URL getUrl = new URL(url);
		URLConnection urlConnection = getUrl.openConnection();
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "utf-8"));

		String line;
		while((line = bufferedReader.readLine()) != null) {
			System.out.println(line);
		}

		bufferedReader.close();*/

		//=========================这里用另一种方式==================================================

		HttpClient httpClient = new HttpClient();
		PostMethod post = new PostMethod(url);
		httpClient.executeMethod(post);

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(post.getResponseBodyAsStream(), "utf-8"));

		String line;
		while((line = bufferedReader.readLine()) != null) {
			System.out.println(line);
		}

		bufferedReader.close();

		return "";
	}

    /**
     * 剔除指定字符串及其后字符串
     *
     * @author sunyiban
     * @date 2018/9/3 10:05
     * @param src
     * @param trimString
     * @return java.lang.String
     */
    public static String trimEnd(String src, String trimString) {
        if (src == null || src.length() < 1) {
            return null;
        } else {
            return src.endsWith(trimString) ? src.substring(0, src.lastIndexOf(trimString)) : src;
        }
    }

	public static void main(String[] args) throws Exception{
		String result = post("https://baike.baidu.com/item/ssl/320778?fr=aladdin", null);
		System.out.println(result);
	}

}
