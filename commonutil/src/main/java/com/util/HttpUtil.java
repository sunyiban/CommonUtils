package com.util;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
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
    public static String doPost(String url, String params) throws IOException {
        URL postUrl = new URL(url);
        StringBuilder stringBuilder = new StringBuilder();
        if (postUrl.getProtocol().equals("https")) {
            HttpsURLConnection connection = (HttpsURLConnection)postUrl.openConnection();
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setUseCaches(false);
            PrintWriter out = null;
            out = new PrintWriter(connection.getOutputStream());
            out.print(params);
            out.flush();
            out.close();
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));
            String line = "";

            while((line = in.readLine()) != null) {
                stringBuilder.append(line);
            }

            in.close();
            connection.disconnect();
        } else {
            HttpURLConnection connection = (HttpURLConnection)postUrl.openConnection();
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setRequestMethod("POST");
            connection.setUseCaches(false);
            connection.setInstanceFollowRedirects(true);
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            connection.connect();
            DataOutputStream out = new DataOutputStream(connection.getOutputStream());
            if (params != null && params.length() > 0) {
                out.writeBytes(params);
            }

            out.flush();
            out.close();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));
            String line = "";

            while((line = reader.readLine()) != null) {
                stringBuilder.append(line);
            }

            reader.close();
            connection.disconnect();
        }

        return stringBuilder.toString();
    }

    public static String doGet(String url, Map<String, String> params) throws IOException {
        String content = "";
        if (params != null && params.size() > 0) {
            StringBuilder sb = new StringBuilder();
            Iterator i$ = params.keySet().iterator();

            while(i$.hasNext()) {
                String key = (String)i$.next();
                sb.append(key + "=" + URLEncoder.encode((String)params.get(key), "utf-8"));
                sb.append("&");
            }

            content = sb.toString();
        }

        String getURL = trimEnd(url, "?") + content;
        URL getUrl = new URL(getURL);
        HttpURLConnection connection = (HttpURLConnection)getUrl.openConnection();
        connection.connect();
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));
        StringBuilder stringBuilder = new StringBuilder();

        String line;
        while((line = reader.readLine()) != null) {
            stringBuilder.append(line);
        }

        reader.close();
        connection.disconnect();
        return stringBuilder.toString();
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
}
