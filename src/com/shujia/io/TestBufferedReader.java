package com.shujia.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * 字符缓冲流
 */
public class TestBufferedReader {
    public static void main(String[] args) throws Exception {
        String path = "E:\\bigdata\\java\\data\\students.txt";
        //1、搭建管道
        FileReader reader = new FileReader(path);
        //对字符输入流做一层封装，加上内存缓冲区，提高读取数据的效率
        BufferedReader bufferedReader = new BufferedReader(reader);

        //2、读取数据
       /* String line = bufferedReader.readLine();
        while (line!=null){
            System.out.println(line);
            line = bufferedReader.readLine();
        }*/

        String line ;
        while ((line=bufferedReader.readLine())!=null){
            System.out.println(line);
        }

        //2、关闭管道
        bufferedReader.close();
        reader.close();


    }
}
