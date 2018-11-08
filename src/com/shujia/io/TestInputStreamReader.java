package com.shujia.io;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * 转换流
 * 文件字节流---->文件字符流--->缓冲流
 *
 */
public class TestInputStreamReader {
    public static void main(String[] args) throws Exception{
        //1、搭建管道
        //创建字节流，没有编码的，和编码没有关系
        FileInputStream in = new FileInputStream("E:\\tmp\\in\\hello.txt");

        //将字节流转换成字符流，默认使用jvm编码集，可以手动指定
        InputStreamReader reader = new InputStreamReader(in,"GBK");

        //字符流转缓冲流，提高读取效率
        BufferedReader bufferedReader = new BufferedReader(reader);

        String line ;
        while ((line=bufferedReader.readLine())!=null){
            System.out.println(line);
        }

        reader.close();
        in.close();


    }
}
