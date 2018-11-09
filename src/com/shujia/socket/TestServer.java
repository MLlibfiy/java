package com.shujia.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务端
 */
public class TestServer {
    public static void main(String[] args) throws IOException {
        //创建服务端socket对象，指定绑定的端口号
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务端已启动");
        //等待客户端发起请求，如果接收到客户端的请求这行代码才会执行
        Socket socket = serverSocket.accept();

        //接受数据
        //获取输入流对象，接收客户端发送过来的数据
        InputStream in = socket.getInputStream();
        InputStreamReader reader = new InputStreamReader(in);
        BufferedReader bufferedReader = new BufferedReader(reader);
        String line = bufferedReader.readLine();
        System.out.println(line);
        socket.shutdownInput();

        //响应数据
        OutputStream out = socket.getOutputStream();
        ObjectOutputStream outputStream = new ObjectOutputStream(out);
        outputStream.writeUTF("请求已收到");
        outputStream.flush();

        socket.shutdownOutput();
        serverSocket.close();



    }
}
