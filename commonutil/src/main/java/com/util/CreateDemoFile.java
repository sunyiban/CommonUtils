package com.util;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author sunyiban
 * @title: CreateDemoFile
 * @copyright: Copyright (c) 2018
 * @description: 创建模板文件<br>
 * @created on 2020/10/30下午3:48
 */
public class CreateDemoFile {

    private static final String BASE_PATH = "/home/sunyiban/HKprojects/hn-ea-archives-all/ea-archive-repenish";
    private static final String SERVICE_PATH = BASE_PATH + "/src/main/java/com/pcitc/ea/archive/repenish/service/" + "test/";
    private static Set<String> modelNames = new HashSet<>(5);

    public static void main(String[] args) throws Exception {
        File file = new File(BASE_PATH);

        getFilePath(file);

        modelNames.forEach(System.out::println);

        modelNames.forEach(name -> {
            try {
                File serviceFile = new File(SERVICE_PATH + name + "Service.java");

                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(serviceFile)));
                String serviceName = name + "Service";
                bw.write("package com.pcitc.ea.archive.repenish.service;\n\n\n");
                bw.newLine();
                bw.write("@TypeMapping(\""+ serviceName.substring(0, 1).toLowerCase() + serviceName.substring(1) +"\")");
                bw.newLine();
                bw.write("public interface " + serviceName + " { \n\n");
                bw.newLine();
                bw.write("\t@MethodMapping(\"add" + name + "\")");
                bw.newLine();
                bw.write("\tvoid add" + name + "(" + name + "DTO " + name.substring(0,1).toLowerCase() + name.substring(1) + "DTO);\n\n");
                bw.newLine();
                bw.write("\t@MethodMapping(\"get" + name + "\")");
                bw.newLine();
                bw.write("\tvoid get" + name + "(" + name + "DTO " + name.substring(0,1).toLowerCase() + name.substring(1) + "DTO);\n\n");
                bw.newLine();
                bw.write("\t@MethodMapping(\"update" + name + "\")");
                bw.newLine();
                bw.write("\tvoid update" + name + "(" + name + "UpdateDTO " + name.substring(0,1).toLowerCase() + name.substring(1) + "UpdateDTO);\n\n");
                bw.newLine();
                bw.write("\t@MethodMapping(\"list" + name + "\")");
                bw.newLine();
                bw.write("\tList<"+ name + "DTO> list" + name + "("+ name + "ListParam " + name.substring(0,1).toLowerCase() + name.substring(1) + "QueryDTO);\n");
                bw.newLine();
                bw.write("}");

                bw.flush();
                bw.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        });

    }

    public static String getFilePath(File file) {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File f : files) {
                if ("model".equalsIgnoreCase(f.getName())) {
                    File[] models = f.listFiles();
                    for (File model : models) {
                        modelNames.add(model.getName().substring(0, model.getName().indexOf(".")));
                    }
                }
                getFilePath(f);
            }
        }
        return file.getAbsolutePath();
    }
}
