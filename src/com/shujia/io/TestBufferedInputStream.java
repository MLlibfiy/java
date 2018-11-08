package com.shujia.io;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class TestBufferedInputStream {
    public static void main(String[] args) throws Exception {
        FileInputStream in = new FileInputStream("E:\\tmp\\in\\hello.txt");

        BufferedInputStream bufferedInputStream = new BufferedInputStream(in);
        int read = bufferedInputStream.read();

        while (read!=-1){
            System.out.println((char)read);
            read = bufferedInputStream.read();
        }
        bufferedInputStream.close();
        in.close();


    }
}
