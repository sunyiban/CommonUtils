package com.util;

import org.apache.commons.codec.binary.Base64;
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

    /**
     * 根据URL获取文件流并返回base64后的字符串
     *
     * @author sunyiban
     * @date 2018/9/1 15:32
     * @param urlPath
     * @return java.lang.String
     */
    public static String getUrlResource(String urlPath) {
		String result = null;
		InputStream inputStream = null;
		try {
			// 这是一些测试用的地址，在使用这个方法的时候遇到一个问题，就是读取不到文件流的内容
//			URL url = new URL("https://file.52touzi.cn/file/show/5b97c40ee4b0d5c4d6a8cab3.png");
//			URL url = new URL("https://ss0.bdstatic.com/5aV1bjqh_Q23odCf/static/superman/img/logo/bd_logo1_31bdc765.png");
//			URL url = new URL("http://thyrsi.com/t6/369/1536675023x-1566680355.png");
			URL url = new URL(urlPath);
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();

			//设置超时间为3秒
			conn.setConnectTimeout(3*1000);
			//防止屏蔽程序抓取而返回403错误
			conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");

			//得到输入流
			inputStream =  conn.getInputStream();

			// 原因就是inputStream.available()这个方法，这个方法默认返回值为0，如果没有重写的话，他的返回值会受到你网络传输的影响，
			// 比如一条100Byte的数据传输过来，inputStream.available()的值可能是100 也可能是50 或者0，这时候直接使用
			// inputStream.available()来作为读取对象的字节长度就会出问题
			// 以下这个方法可以解决问题，但不是最好的方案，所以使用这个方法时要是否慎重
			int count = 0;
			while (count == 0) {
				count = inputStream.available();
			}

			byte[] imageBytes = new byte[inputStream.available()];
			inputStream.read(imageBytes);
			result = Base64.encodeBase64String(imageBytes);

			System.out.println(result);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}

	public static void main(String[] args) throws Exception{
		String result = post("https://baike.baidu.com/item/ssl/320778?fr=aladdin", null);
		System.out.println(result);
	}

}
