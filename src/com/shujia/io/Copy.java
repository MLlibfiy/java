package com.shujia.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 文件复制
 */
public class Copy {
    public static void main(String[] args) throws IOException {
        //1、打开管道
        FileInputStream in = new FileInputStream("");
        FileOutputStream out = new FileOutputStream("");

        //2、读取数据，同时写出
        int b = in.read();
        while (b!=-1){
            out.write(b);
            //读取下一个
            b = in.read();
        }

        //3、关闭管道
        out.close();
        in.close();
    }
}
