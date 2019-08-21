package com.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @autor sunyiban
 * @date 2019/7/30 16:54
 * @descrpition
 */
public class Ffmpeg {
    public static void main(String[] args) {
        //启动nginx
        String cmd = "cmd /c E: && cd nginx && start nginx";
        //关闭nginx
        //String stop ="cmd /c E: && cd nginx && nginx.exe -s quit";
        Runtime run = Runtime.getRuntime();
        try {
            java.lang.Process process = run.exec(cmd);
            InputStream in = process.getInputStream();
            System.out.println(cmd);
            while (in.read()!=-1){
                System.out.println(in.read());
            }
            in.close();
            process.waitFor();
        } catch (IOException | InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        String all = "cmd /c start ffmpeg -i \"rtsp://admin:huazhen@123@172.16.13.253:554/Streaming/Channels/101?transportmode=unicast\" "
                + "-f flv -r 25 -an -s 640*480 \"rtmp://localhost:1935/live/\"";
        String line =null;
        StringBuilder sb = new StringBuilder();
        Runtime runtime = Runtime.getRuntime();
        try {
            System.out.println(all);
            java.lang.Process process = runtime.exec(all);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            while((line = bufferedReader.readLine())!= null){
                sb.append(line + "\n");
                System.out.println(line);
                process.destroy();
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
