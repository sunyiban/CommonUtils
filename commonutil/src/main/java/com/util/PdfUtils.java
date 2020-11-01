package com.util;

import com.lowagie.text.Document;
import com.lowagie.text.pdf.PdfCopy;
import com.lowagie.text.pdf.PdfImportedPage;
import com.lowagie.text.pdf.PdfReader;

import java.io.*;
import java.util.Arrays;
import java.util.List;

/**
 * @author sunyiban
 * @title: PdfUtils
 * @copyright: Copyright (c) 2018
 * @description: <br>
 * @created on 2020/11/1下午5:30
 */
public class PdfUtils {

    public static void main(String[] args) throws Exception{
        String filePath1 = "/home/sunyiban/Documents/test.pdf";
        String filePath2 = "/home/sunyiban/Documents/test1.pdf";

        InputStream fis = new FileInputStream(new File(filePath1));
        InputStream fis1 = new FileInputStream(new File(filePath2));

        List<InputStream> fisArray = Arrays.asList(fis, fis1);
        byte[] result = mergePdfFiles(fisArray);

        FileOutputStream fos = new FileOutputStream(new File("/home/sunyiban/Documents/test2.pdf"));
        fos.write(result);
        fos.close();
    }

    /**
     * pdf合并
     * @param inputStreams 要合并的pdf的InputStream数组
     * @return 合并后的pdf的二进制内容
     */
    private static byte[] mergePdfFiles(List<InputStream> inputStreams) {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        Document document = new Document();// 创建一个新的PDF
        byte[] pdfs = new byte[0];
        try {
            PdfCopy copy = new PdfCopy(document, bos);
            document.open();
            for (InputStream is : inputStreams) {// 取出单个PDF的数据
                PdfReader reader = new PdfReader(InputStream2byte(is));
                int pageTotal= reader.getNumberOfPages();
//                logger.info("pdf的页码数是 ==> {}",pageTotal);
                for (int pageNo=1;pageNo<=pageTotal;pageNo++){
                    document.newPage();
                    PdfImportedPage page = copy.getImportedPage(reader, pageNo);
                    copy.addPage(page);
                }
                reader.close();
            }
            document.close();
            pdfs = bos.toByteArray();
            bos.close();
            copy.close();
        } catch (Exception e) {
            throw new RuntimeException("合并PDF出错：" + e);
        }
        return pdfs;
    }

    public static byte[] InputStream2byte(InputStream inputStream) {
        byte[] buffer;
        try (InputStream fis = inputStream;
             ByteArrayOutputStream bos = new ByteArrayOutputStream()){
            byte[] b = new byte[1024];
            int n;
            while ((n = fis.read(b)) != -1)
            {
                bos.write(b, 0, n);
            }
            buffer = bos.toByteArray();
        }catch (Exception e){
            throw new RuntimeException("错误");
        }
        return buffer;
    }

}
