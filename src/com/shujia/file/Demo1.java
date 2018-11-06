package com.shujia.file;

import java.io.File;
import java.io.IOException;

/**
 * file基础属性
 *
 */
public class Demo1 {
    public static void main(String[] args) throws IOException {
        //创建文件对象，相当于在java程序里面创建了一个文件的抽象
        File file = new File("E:\\tmp\\hello.txt");
        //判断文件是否存在
        System.out.println(file.exists());
        //判断是否是文件
        System.out.println(file.isFile());
        //判断是否是目录
        System.out.println(file.isDirectory());
        System.out.println(file.getPath());
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getName());
        //删除文件，如果文件不存在返回false
//        System.out.println(file.delete());

        //创建文件，不能创建目录，文件已存在不能创建
        System.out.println(file.createNewFile());
        System.out.println(file.length());

        File file1 = new File("E:\\bigdata\\java\\src\\com\\shujia");

        //获取目录下的文件名集合
        for (String s : file1.list()) {
            System.out.println(s);
        }

        //获取目录下的文件对象
        for (File file2 : file1.listFiles()) {
            System.out.println(file2.toString());

        }

    }
}
