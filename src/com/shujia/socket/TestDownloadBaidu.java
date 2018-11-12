package com.shujia.socket;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 *
 * 下载百度首页
 *
 * 网络爬虫
 */
public class TestDownloadBaidu {

    public static void main(String[] args)throws Exception {
        //建立连接，三次握手
        Socket socket = new Socket("www.hfnu.edu.cn", 80);
        InputStream inputStream = socket.getInputStream();

        int read = inputStream.read();
        while (read!=-1){
            System.out.println((char)read);
            read = inputStream.read();
        }

        socket.shutdownInput();




    }
}
