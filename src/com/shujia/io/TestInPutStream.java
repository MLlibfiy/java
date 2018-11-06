package com.shujia.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 字节输入流
 */
public class TestInPutStream {
    public static void main(String[] args) throws IOException {
        File file = new File("E:\\tmp\\hello.txt");
        //1、搭建管道
        //创建字节输入流对象
        FileInputStream in = new FileInputStream(file);
        //2、读取数据
        //in.read() 一个一个读取，如果到末尾返回-1
        /*int read = in.read();
        while (read != -1) {
            System.out.print((char) read);
            //读取下一个字节
            read = in.read();
        }*/

        //一次读取多个字节

        byte[] bytes = new byte[1024];
        //返回值是这一次读了多少字节
        int size = in.read(bytes);
        String s = new String(bytes, 0, size,"GBK");
        System.out.println(s);

        //3、关闭管道
        in.close();

    }
}
