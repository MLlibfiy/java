package com.shujia.io;

import java.io.FileWriter;
import java.io.IOException;

/**
 * 字符输出流
 */
public class TestWriter {
    public static void main(String[] args) throws IOException {

        //1、搭建管道
        FileWriter writer = new FileWriter("E:\\tmp\\out\\hello.txt");

        //2、写数据
        writer.write("我爱数加");
        writer.write(97);

        writer.close();

    }
}
