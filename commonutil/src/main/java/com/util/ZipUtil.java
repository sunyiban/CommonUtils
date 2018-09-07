package com.util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @author sunyiban
 * @version V 1.0
 * @Title ZipUtil -> Class
 * @Package CommonUtils -> com.util
 * @Description ZIP解/压缩
 * @date 2018/9/7 9:33 
 */
public class ZipUtil {

	/**
	 * 浏览文件夹下的所有文件
	 *
	 * @author sunyiban
	 * @date 2018/9/7 9:43
	 * @param file
	 * @return java.io.File
	 */
	public static File listFileDirecotry(File file) {
		if (file == null || !file.exists()) {
			return null;
		}

		if (file.isDirectory()) {
			File[] files = file.listFiles();
			for (File f : files) {
				if (f.isDirectory()) {
					System.out.println(f.getName());
					listFileDirecotry(f);
				} else {
					System.out.println(f.getName());
				}
			}
		}

		return file;
	}

	/**
	 * 压缩单个文件
	 * 文件路径 ex: e:/a.zip 必须以.zip为后缀，如果不传或者不满足条件，默认获取压缩文件的绝对路径：
	 * 例：传入文件 e:/a.txt ==> 压缩后文件 e:/a.zip
	 *
	 * @author sunyiban
	 * @date 2018/9/7 10:17
	 * @param file 需要压缩的文件
	 * @param fileName 文件路径
	 * @return java.io.File
	 */
	public static File zipSingleFile(File file, String fileName) {
		if (file == null || !file.exists()) {
			return null;
		}

		File zipedFile = null;
		ZipOutputStream zos = null;
		BufferedInputStream bis = null;
		try {
			if (fileName == null || fileName.length() < 1 || !fileName.endsWith(".zip")) {
				fileName = file.getAbsolutePath().substring(0, file.getAbsolutePath().lastIndexOf(".")) + ".zip";
			}
			zipedFile = new File(fileName);
			zos = new ZipOutputStream(new FileOutputStream(zipedFile));
			ZipEntry zipEntry = new ZipEntry("aaa/bbb/ccc/" + file.getName());
			zos.putNextEntry(zipEntry);

			bis = new BufferedInputStream(new FileInputStream(file));
			byte[] readByte = new byte[1024];
			int len;
			while ((len = bis.read(readByte)) > 0) {
				zos.write(readByte, 0, len);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (zos != null) {
					zos.close();
				}
				if (bis != null) {
					bis.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return zipedFile;
	}

	/**
	 * 压缩多个文件
	 * 文件路径 ex: e:/a.zip 必须以.zip为后缀，如果不传或者不满足条件，默认获取压缩文件列表第一个文件的绝对路径：
	 * 例：传入文件 [e:/a.txt, c:/b.txt] ==> 压缩后文件 e:/a.zip
	 *
	 * @author sunyiban
	 * @date 2018/9/7 10:17
	 * @param files 需要压缩的文件列表
	 * @param fileName 文件路径
	 * @return java.io.File
	 */
	public static File zipFileList(List<File> files, String fileName) {
		if (files == null || files.size() < 1) {
			return null;
		}

		if (files.size() == 1) {
			return zipSingleFile(files.get(0), fileName);
		}

		if (fileName == null || fileName.length() < 1 || !fileName.endsWith(".zip")) {
			fileName = files.get(0).getAbsolutePath().substring(0, files.get(0).getAbsolutePath().lastIndexOf(".")) + ".zip";
		}

		File zipedFile = null;
		ZipOutputStream zos = null;
		BufferedInputStream bis = null;
		try {
			zipedFile = new File(fileName);
			zos = new ZipOutputStream(new FileOutputStream(zipedFile));

			for (File f : files) {
				ZipEntry zipEntry = new ZipEntry(f.getName());
				zos.putNextEntry(zipEntry);

				bis = new BufferedInputStream(new FileInputStream(f));
				byte[] readByte = new byte[1024];
				int len;
				while ((len = bis.read(readByte)) > 0) {
					zos.write(readByte, 0, len);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (zos != null) {
					zos.close();
				}
				if (bis != null) {
					bis.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return zipedFile;
	}


	public static void main(String[] args) throws Exception {
//		listFileDirecotry(new File("E:/workspace"));
		zipSingleFile(new File("E:/t.png"), "E:/t.zip");

		/*List<File> listFile = new ArrayList<File>();
		listFile.add(new File("E:/test.pdf"));
		listFile.add(new File("E:/test1.pdf"));
		listFile.add(new File("E:/test2.pdf"));
		zipFileList(listFile, "E:/test.zip");*/
	}

}
