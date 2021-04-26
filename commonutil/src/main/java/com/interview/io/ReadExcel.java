package com.interview.io;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

/**
 * @author sunyiban@panda-fintech.com
 * @title: ReadExcel
 * @copyright: Copyright (c) 2018
 * @description: <br>
 * @company: panda-fintech
 * @created on 2019/11/21下午4:16
 */
public class ReadExcel {
  private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
  private static DecimalFormat nf = new DecimalFormat("0");
  public static void main(String[] args) throws Exception {
    read2007ExcelByJob();
    emergency();
  }

  public static void read2007ExcelByJob() throws IOException {
    File file = new File("/home/sunyiban/test/contact.xlsx");
    List<List<Object>> list = new LinkedList<List<Object>>();
    // 构造 XSSFWorkbook 对象，strPath 传入文件路径
    XSSFWorkbook xwb = new XSSFWorkbook(new FileInputStream(file));

    // 读取第一章表格内容
    XSSFSheet sheet = xwb.getSheetAt(0);
    Object value = null;
    XSSFRow row = null;
    XSSFCell cell = null;

    Object oneColumn = "";
    Object towColumn = "";
    String val = "";

    File newFile = new File("/home/sunyiban/test/contact.sql");
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(newFile)));

    //循环行
    for (int i = sheet.getFirstRowNum() + 1; i <= sheet.getPhysicalNumberOfRows(); i++) {
      row = sheet.getRow(i);//获取行
      if (row == null) {
        continue;
      }

      String idnumber = row.getCell(1).getStringCellValue().trim();
      cell = row.getCell(3);
      val = cell.getStringCellValue();
      String[] vals = val.split(";");
      int k = 0;
      for (int l = 0; l < vals.length; l++) {
        XSSFCell newRow = row.createCell(4 + k);
        k = k+1;
        String content = vals[l].replace("/", "");
        String cont = content.replaceFirst("\\d", "|");
        try {
          int len = cont.indexOf("|");
          if (len == -1) {
            newRow.setCellValue(content);
            newRow = row.createCell(4 + k);
            newRow.setCellValue("");
          } else {
            String customerName = content.substring(0, len).trim().replaceAll("'", "");
            if (StringUtils.isBlank(customerName)) {
              continue;
            }
            newRow.setCellValue(customerName);
            newRow = row.createCell(4 + k);
            String line = content.substring(len);
            if (line.startsWith("+84")) {
              line = line;
            } else if (line.startsWith("0")) {
              line = line.replaceFirst("^0", "+84");
            } else if (line.startsWith("84")) {
              line = line.replaceFirst("84", "+84");
            } else if (StringUtils.isNotBlank(line)) {
              line = "+84" + line;
            }
            newRow.setCellValue(line);

            // select '+84', pu.uid, cc.customer_id, 'A.Mạnh.Vp.INCM', '+84903407088' from customer.customers cc left join passport.users pu on pu.customer_id = cc.customer_id where cc.id_card_no='680269421';
            String bwline = "insert into dw.user_contacts (country_code, uid, customer_id, display_name, phone) select '+84', pu.uid, cc.customer_id, '" + customerName + "', '"+ line.replaceAll(" ", "") + "' from customer.customers cc left join passport.users pu on pu.customer_id = cc.customer_id where cc.id_card_no = '" + idnumber + "';";
            bw.write(bwline);
            bw.newLine();
            bw.flush();
            // 联系人
            // insert into dw.user_contacts (country_code, uid, customer_id, display_name, phone) select '+84', dw.user_bases.uid, dw.user_bases.customer_id, '', '' from dw.user_bases where dw.user_bases.id_card_no = '';
            // 紧急联系人
            // insert into dw.user_emergency_contacts (country_code, uid, customer_id, real_name, phone, relationship) select '+84', dw.user_bases.uid, dw.user_bases.customer_id, '111', '222', '300942' from dw.user_bases where dw.user_bases.id_card_no = '4343464646646464';

          }

        } catch (Exception e) {
          System.out.println(cont);
        }
        k = k+1;
      }


      //循环列
//      for (int j = row.getFirstCellNum(); j <= row.getLastCellNum(); j++) {
//        cell = row.getCell(j);
//        if (cell == null) {
//          continue;
//        }
//        System.out.println(cell.getStringCellValue());
//
//        if (value == null || "".equals(value)) {
//          continue;
//        }
//      }
    }

    FileOutputStream fos = new FileOutputStream(file);
    xwb.write(fos);

    xwb.close();
    fos.close();
  }


  public static void emergency() throws IOException {
    File file = new File("/home/sunyiban/test/emergency.xlsx");
    List<List<Object>> list = new LinkedList<List<Object>>();
    // 构造 XSSFWorkbook 对象，strPath 传入文件路径
    XSSFWorkbook xwb = new XSSFWorkbook(new FileInputStream(file));

    // 读取第三章表格内容
    XSSFSheet sheet = xwb.getSheetAt(2);
    Object value = null;
    XSSFRow row = null;
    XSSFCell cell = null;

    Object oneColumn = "";
    Object towColumn = "";
    String val = "";

    File newFile = new File("/home/sunyiban/test/emergencycontact.sql");
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(newFile)));

    //循环行
    for (int i = sheet.getFirstRowNum() + 1; i <= sheet.getPhysicalNumberOfRows(); i++) {
      row = sheet.getRow(i);//获取行
      if (row == null) {
        continue;
      }

      // 第一列身份证
      String idnumber = row.getCell(0).getStringCellValue().trim();

      // 循环列
      for (int f = 1; f <= 15; f++) {
        cell = row.getCell(f);
        if (cell == null) {
          continue;
        }
        try {
          val = cell.getStringCellValue();
        } catch (Exception e) {
          val = cell.getNumericCellValue()+ "";
        }
        // 一列姓名 一列身份证
        f = f + 1;
        cell = row.getCell(f);
        if (cell == null) {
          continue;
        }
        String number = cell.getStringCellValue().replaceAll(" ", "");
        // 紧急联系人
        // insert into dw.user_emergency_contacts (country_code, uid, customer_id, real_name, phone, relationship) select '+84', dw.user_bases.uid, dw.user_bases.customer_id, '111', '222', '300942' from dw.user_bases where dw.user_bases.id_card_no = '4343464646646464';
        if (StringUtils.isNotBlank(val) && StringUtils.isNotBlank(number)) {
          String sql = "insert into dw.user_emergency_contacts (country_code, uid, customer_id, real_name, phone, relationship) select '+84', pu.uid, cc.customer_id, '" + val.trim().replaceAll("'", "") + "', '" + number + "', '300942' from customer.customers cc left join passport.users pu on pu.customer_id = cc.customer_id where cc.id_card_no = '" + idnumber + "';";
          bw.write(sql);
          bw.newLine();
          bw.flush();
        }
      }

    }
      FileOutputStream fos = new FileOutputStream(file);
      xwb.write(fos);

      xwb.close();
      fos.close();
      bw.close();
    }

}
