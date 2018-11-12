package com.shujia.thread;

import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务端
 *
 */
public class TestThreadServer {
    public static void main(String[] args) throws Exception{
        System.out.println("服务端已启动");
        ServerSocket serverSocket = new ServerSocket(9999);

        //等待客户端连接
        Socket socket = serverSocket.accept();
        ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
        Thread thread = (Thread) inputStream.readObject();
        socket.shutdownInput();
        thread.start();



    }
}
