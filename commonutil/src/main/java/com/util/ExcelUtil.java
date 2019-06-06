package com.util;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import com.sun.istack.internal.NotNull;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.formula.functions.T;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFCell;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @author sunyiban
 * @version V 1.0
 * @Title ExcelUtil -> Class
 * @Package CommonUtils -> com.util
 * @Description
 * @date 2019/4/17 10:44 
 */
public class ExcelUtil {
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private static DecimalFormat nf = new DecimalFormat("0");

	private File file;

	public ExcelUtil() {}

	public ExcelUtil(File file){
		this.file = file;
	}

	public static void main(String[] args) throws Exception {
		//读取Excel文件
		/*ExcelUtil analysis = new ExcelUtil(new File("E:/保险职业.xlsx"));
		try {
			List<List<Object>> oneList = analysis.readExcel();
			for (int i = 0; i < oneList.size(); i++) {
				// 业务处理
			}
		} catch (IOException e) {
			e.printStackTrace();
		}*/

		List<A> list = new ArrayList<>();
		A a = new A(1, 2);
		A a1 = new A(3, 4);
		A a2 = new A(5, 6);
		list.add(a);
		list.add(a1);
		list.add(a2);
		list.add(a2);
		list.add(a2);
		list.add(a2);
		list.add(a2);
		list.add(a2);
		list.add(a2);
		writeToExcel(list, 10);
	}

	/**
	 * 带模板写入excel，空一行一列
	 *
	 * @author sunyiban
	 * @date 2019/6/6 11:41
	 * @param list
	 * @param tempFile
	 * @return void
	 */
	public static <T extends Object> void writeToExcel(List<T> list, File tempFile) throws Exception {
		writeToExcel(list, tempFile, 1, 1);
	}

	/**
	 * 带模板，写入excel
	 *
	 * @author sunyiban
	 * @date 2019/6/6 11:39
	 * @param list
	 * @param tempFile
	 * @param rowStart 开始行
	 * @param cellStart 开始列
	 * @return void
	 */
	public static <T extends Object> void writeToExcel(List<T> list, File tempFile, int rowStart, int cellStart) throws Exception {
		XSSFWorkbook xssfWorkbook = null;
		if (tempFile != null) {
			xssfWorkbook = new XSSFWorkbook(tempFile);
		} else {
			xssfWorkbook = new XSSFWorkbook();
		}

		XSSFSheet xssfSheet = xssfWorkbook.createSheet("测试1");
		XSSFRow row;
		XSSFCell xssfCell;
		int rouNum = rowStart;
		for (Object obj : list) {
			// 创建一行 第0行开始
			row = xssfSheet.createRow(rouNum++);

			Class classes = obj.getClass();
			Field[] field = classes.getDeclaredFields();

			for (int i = 0; i < field.length; i++) {
				// 创建一列
				xssfCell = row.createCell(cellStart + i);

				// 获取参数类的get方法
				String methodName = "get" + field[i].getName().substring(0, 1).toUpperCase() + field[i].getName().substring(1);
				// 调用get方法取值
				Method method = classes.getMethod(methodName);
				// invoke传入的参数是要调用此方法的对象
				Object result = method.invoke(obj);

				if(field[i].getType().isInstance(Integer.class)) {
					xssfCell.setCellValue((Integer) result);
				} else if (field[i].getType().isInstance(Date.class)) {
					xssfCell.setCellValue((Date) result);
				} else if (field[i].getType().isInstance(Double.class)) {
					xssfCell.setCellValue((Double) result);
				} else if (field[i].getType().isInstance(Calendar.class)) {
					xssfCell.setCellValue((Calendar) result);
				} else if (field[i].getType().isInstance(Boolean.class)) {
					xssfCell.setCellValue((Boolean) result);
				} else if (field[i].getType().isInstance(String.class)) {
					xssfCell.setCellValue((String) result);
				} else {
					xssfCell.setCellValue(result.toString());
				}

			}

		}

		FileOutputStream fos = new FileOutputStream(new File("e:/test.xlsx"));
		xssfWorkbook.write(fos);

		xssfWorkbook.close();
		fos.close();
	}

	/**
	 * 写入excel
	 *
	 * @author sunyiban
	 * @date 2019/6/6 11:39
	 * @param list
	 * @return void
	 */
	public static <T extends Object> void writeToExcel(List<T> list) throws Exception {
		writeToExcel(list, null);
	}

	/**
	 * 带模板的缓冲写入，空一行一列
	 *
	 * @author sunyiban
	 * @date 2019/6/6 11:35
	 * @param list
	 * @param tempFile
	 * @param cacheNum 缓冲数
	 * @return void
	 */
	public static <T extends Object> void writeToExcel(List<T> list, File tempFile, int cacheNum) throws Exception {
		writeToExcel(list, tempFile, cacheNum, 1, 1);
	}

	/**
	 * 带模板的缓冲写入
	 *
	 * @author sunyiban
	 * @date 2019/6/6 11:35
	 * @param list
	 * @param tempFile
	 * @param cacheNum 缓冲数
	 * @param rowStart 开始行（除去模板内容外从哪一行开始）
	 * @param cellStart 开始列（除去模板内容外从哪一列开始）
	 * @return void
	 */
	public static <T extends Object> void writeToExcel(List<T> list, File tempFile, int cacheNum, Integer rowStart,
			Integer cellStart) throws Exception {
		SXSSFWorkbook sxssfWorkbook;
		if (tempFile != null) {
			XSSFWorkbook xssfWorkbook = new XSSFWorkbook(tempFile);
			sxssfWorkbook = new SXSSFWorkbook(xssfWorkbook, cacheNum);
		} else {
			sxssfWorkbook = new SXSSFWorkbook(cacheNum);
		}

		SXSSFSheet sxssfSheet = sxssfWorkbook.createSheet("测试1");
		SXSSFRow row;
		SXSSFCell xssfCell;
		int rouNum = rowStart;
		for (Object obj : list) {
			// 创建一行 第0行开始
			row = sxssfSheet.createRow(rouNum++);

			Class classes = obj.getClass();
			Field[] field = classes.getDeclaredFields();

			for (int i = 0; i < field.length; i++) {
				// 创建一列
				xssfCell = row.createCell(cellStart + i);

				// 获取参数类的get方法
				String methodName = "get" + field[i].getName().substring(0, 1).toUpperCase() + field[i].getName().substring(1);
				// 调用get方法取值
				Method method = classes.getMethod(methodName);
				Object result = method.invoke(obj);

				if(field[i].getType().isInstance(Integer.class)) {
					xssfCell.setCellValue((Integer) result);
				} else if (field[i].getType().isInstance(Date.class)) {
					xssfCell.setCellValue((Date) result);
				} else if (field[i].getType().isInstance(Double.class)) {
					xssfCell.setCellValue((Double) result);
				} else if (field[i].getType().isInstance(Calendar.class)) {
					xssfCell.setCellValue((Calendar) result);
				} else if (field[i].getType().isInstance(Boolean.class)) {
					xssfCell.setCellValue((Boolean) result);
				} else if (field[i].getType().isInstance(String.class)) {
					xssfCell.setCellValue((String) result);
				} else {
					xssfCell.setCellValue(result.toString());
				}

			}

		}

		FileOutputStream fos = new FileOutputStream(new File("e:/test.xlsx"));
		sxssfWorkbook.write(fos);

		sxssfWorkbook.close();
		fos.close();
	}

	/**
	 * 带缓存的写入excel方法
	 *
	 * @author sunyiban
	 * @date 2019/6/6 11:25
	 * @param list
	 * @param cacheNum
	 * @return void
	 */
	public static <T extends Object> void writeToExcel(List<T> list, int cacheNum) throws Exception {
		SXSSFWorkbook sxssfWorkbook = new SXSSFWorkbook(cacheNum);
		writeToExcel(list, null, cacheNum);
	}

	/**
	 * 读取excel 的方法
	 */
	public List<List<Object>> readExcel() throws IOException {
		if(!file.exists()){
			return null;
		}

		String fileName = file.getName();
		String extension = fileName.lastIndexOf(".") == -1 ? "" : fileName.substring(fileName.lastIndexOf(".") + 1);
		if ("xls".equals(extension)) {
			return read2003Excel(file);
		} else if ("xlsx".equals(extension)) {
			return read2007ExcelByJob(file);
		} else {
			throw new IOException("不支持的文件类型");
		}
	}


	/**
	 * 读取Office 2007 excel
	 */
	private List<List<Object>> read2007ExcelByJob(File file) throws IOException {

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

		//循环行
		for (int i = sheet.getFirstRowNum() + 1; i <= sheet.getPhysicalNumberOfRows(); i++) {
			row = sheet.getRow(i);//获取行
			if (row == null) {
				continue;
			}

			List<Object> linked = new LinkedList<Object>();
			//循环列
			for (int j = row.getFirstCellNum(); j <= row.getLastCellNum(); j++) {
				cell = row.getCell(j);
				if (cell == null) {
					continue;
				}

				switch (cell.getCellType()) {  //获取数据类型
					case XSSFCell.CELL_TYPE_STRING:
						value = cell.getStringCellValue();
						if(value != null){
							if(j == 0){
								oneColumn = value;
							}
							if(j == 1){
								towColumn = value;
							}
						}
						break;
					case XSSFCell.CELL_TYPE_NUMERIC:
						if ("@".equals(cell.getCellStyle().getDataFormatString())) {
							value = nf.format(cell.getNumericCellValue());
						} else if ("General".equals(cell.getCellStyle().getDataFormatString())) {
							value = nf.format(cell.getNumericCellValue());
						} else {
							value = sdf.format(HSSFDateUtil.getJavaDate(cell.getNumericCellValue()));
						}
						break;
					case XSSFCell.CELL_TYPE_BOOLEAN:
						value = cell.getBooleanCellValue();
						break;
					case XSSFCell.CELL_TYPE_BLANK:
						value = "";
						if(j == 0){
							value = oneColumn;
						}
						if(j == 1){
							value = towColumn;
						}
						break;
					default:
						value = cell.toString();
				}
				if (value == null || "".equals(value)) {
					continue;
				}
				linked.add(value);
			}
			list.add(linked);
		}
		return list;
	}

	/**
	 * 读取 office 2003 excel
	 *
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	private static List<List<Object>> read2003Excel(File file) throws IOException {
		List<List<Object>> list = new LinkedList<List<Object>>();
		HSSFWorkbook hwb = new HSSFWorkbook(new FileInputStream(file));
		HSSFSheet sheet = hwb.getSheetAt(0);
		Object value = null;
		HSSFRow row = null;
		HSSFCell cell = null;
		System.out.println("读取office 2003 excel内容如下：");
		for (int i = sheet.getFirstRowNum(); i <= sheet.getPhysicalNumberOfRows(); i++) {
			row = sheet.getRow(i);
			if (row == null) {
				continue;
			}
			List<Object> linked = new LinkedList<Object>();
			for (int j = row.getFirstCellNum(); j <= row.getLastCellNum(); j++) {
				cell = row.getCell(j);
				if (cell == null) {
					continue;
				}
				DecimalFormat df = new DecimalFormat("0");// 格式化 number String
				// 字符
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 格式化日期字符串
				DecimalFormat nf = new DecimalFormat("0.00");// 格式化数字
				switch (cell.getCellType()) {
					case XSSFCell.CELL_TYPE_STRING:
						value = cell.getStringCellValue();
						break;
					case XSSFCell.CELL_TYPE_NUMERIC:
						if ("@".equals(cell.getCellStyle().getDataFormatString())) {
							value = df.format(cell.getNumericCellValue());

						} else if ("General".equals(cell.getCellStyle().getDataFormatString())) {
							value = nf.format(cell.getNumericCellValue());
						} else {
							value = sdf.format(HSSFDateUtil.getJavaDate(cell.getNumericCellValue()));
						}
						System.out.print("  " + value + "  ");
						break;
					case XSSFCell.CELL_TYPE_BOOLEAN:
						value = cell.getBooleanCellValue();
						System.out.print("  " + value + "  ");
						break;
					case XSSFCell.CELL_TYPE_BLANK:
						value = "";
						System.out.print("  " + value + "  ");
						break;
					default:
						value = cell.toString();
				}
				if (value == null || "".equals(value)) {
					continue;
				}
				linked.add(value);

			}
			list.add(linked);
		}

		return list;
	}

	static class A{
		int a;
		int b;

		public A(int a, int b) {
			this.a = a;
			this.b = b;
		}

		public int getA() {
			return a;
		}

		public void setA(int a) {
			this.a = a;
		}

		public int getB() {
			return b;
		}

		public void setB(int b) {
			this.b = b;
		}
	}
}
