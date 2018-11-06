package com.shujia.file;

import java.io.File;

/**
 * 递归打印目录及所有子文件和目录
 */
public class Demo2 {
    public static void main(String[] args) {
        File file = new File("E:\\bigdata\\java\\src\\com\\shujia");
        point(file);
    }

    public static void point(File file) {
        if (file.isFile()) {
            System.out.println(file.getPath());
        } else {
            //循环这个目录下的所有文件或目录，递归调用point方法
            File[] files = file.listFiles();
            for (File f : files) {
                point(f);
            }
        }
    }

}
