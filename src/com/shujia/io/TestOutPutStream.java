package com.shujia.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 字节输出流
 */
public class TestOutPutStream {
    public static void main(String[] args) throws IOException {
        byte[] b = {'s', 'h', 'u', 'j', 'i', 'a'};

        File file = new File("E:\\tmp\\out.txt");

        //1、搭建管道
        //如果文件不存在，自动创建
        //append 默认是覆盖，如果想追加，后面接true
        FileOutputStream out = new FileOutputStream(file,true);

        //2、写数据
        out.write(b);

        //3、关闭管道
        out.close();


    }
}
