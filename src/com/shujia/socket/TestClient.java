package com.shujia.socket;

import java.io.*;
import java.net.Socket;

/**
 * 客户端
 */
public class TestClient {
    public static void main(String[] args) throws Exception {

        //创建客服端socket对象，相当于和服务端建立连接
        Socket socket = new Socket("localhost", 9999);
        //获取客服端想服务端发送数据的流对象
        OutputStream out = socket.getOutputStream();

        OutputStreamWriter writer = new OutputStreamWriter(out);
        BufferedWriter bufferedWriter = new BufferedWriter(writer);
        bufferedWriter.write("你好：百度");
        bufferedWriter.flush();
        //关闭流对象
        socket.shutdownOutput();

        //接受服务端的响应
        InputStream in = socket.getInputStream();
        ObjectInputStream inputStream = new ObjectInputStream(in);
        String result = inputStream.readUTF();
        System.out.println("服务端响应结果：" + result);



        socket.shutdownInput();

        System.out.println("请求已完成");


    }
}
