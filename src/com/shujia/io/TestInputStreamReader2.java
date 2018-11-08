package com.shujia.io;

import java.io.*;

public class TestInputStreamReader2 {
    public static void main(String[] args) throws Exception{
        //获取控制台字节输入流
        InputStream in = System.in;
        System.out.println(1);
        InputStreamReader reader = new InputStreamReader(in);
        System.out.println(2);
        BufferedReader bufferedReader = new BufferedReader(reader);
        System.out.println(3);
        System.out.println(bufferedReader.readLine());
        System.out.println(4);

        //获取控制台字节输出流（也叫打印流）
        PrintStream out = System.out;
        OutputStreamWriter writer = new OutputStreamWriter(out);
        writer.write("控制台字节输出流-->字符输出流");
        writer.flush();
        //关闭之后控制台输出流就不能用了  不能使用System.out.println(4);
        writer.close();




    }
}
