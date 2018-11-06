package com.shujia.io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * 字符输入流
 */
public class TestReader {
    public static void main(String[] args) throws IOException {

        //1、搭建管道
        FileReader reader = new FileReader("E:\\tmp\\in\\hello.txt");

        //2、读取数据
        //一次读取一个字符
        /* int c = 0;
        while ((c = reader.read()) != -1) {
            System.out.print((char)c);
        }*/

        //一次读取多个字符

        char[] chars = new char[1024];
        int length = reader.read(chars);

        String s = new String(chars, 0, length);
        System.out.println(s);

        //3、关闭管道
        reader.close();
    }
}
