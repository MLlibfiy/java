package com.shujia.io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * 字符缓冲输出流
 *
 */
public class TestBufferedWriter {
    public static void main(String[] args) throws IOException {
        FileWriter writer = new FileWriter("E:\\tmp\\out\\hello.txt");

        BufferedWriter bufferedWriter = new BufferedWriter(writer);

        bufferedWriter.write("我爱数加");
        //新建一行
        bufferedWriter.newLine();
        bufferedWriter.write("我虽浪迹天涯");
        bufferedWriter.write("却未迷失本心");

        bufferedWriter.close();
        writer.close();


    }
}
