package com.shujia.io;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

/**
 * 字节输出流-->字符输出流
 *
 */
public class TestOutPutStreamWriter {
    public static void main(String[] args) throws Exception{

        //创建字节输出流
        FileOutputStream out = new FileOutputStream("E:\\tmp\\out\\hello.txt");

        //将字节输出流转换成字符输出流，默认编码是jvm的默认编码
        OutputStreamWriter writer = new OutputStreamWriter(out,"GBK");

        BufferedWriter bufferedWriter = new BufferedWriter(writer);

        bufferedWriter.write("我爱数加");
        bufferedWriter.flush();

        bufferedWriter.close();
        writer.close();
        out.close();


    }
}
