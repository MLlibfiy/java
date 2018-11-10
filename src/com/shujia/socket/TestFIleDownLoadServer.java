package com.shujia.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 文件下载，服务端
 */
public class TestFIleDownLoadServer {

    public static void main(String[] args) throws Exception {
        //获取文件列表
        File file = new File("E:\\download");
        File[] files = file.listFiles();


        ServerSocket serverSocket = new ServerSocket(8888);
        System.out.println("服务端已启动......");
        while (true) {
            Socket socket = serverSocket.accept();

            /**
             * 1、提供查询文件列表的服务
             * 将可以下载的文件列表返回给客户端
             */
            OutputStream out = socket.getOutputStream();
            ObjectOutputStream outputStream = new ObjectOutputStream(out);
            outputStream.writeObject(files);
            outputStream.flush();

            /**
             * 获取客户端发送过来的文件对象
             *
             */

            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
            File file1 = (File) inputStream.readObject();

            System.out.println(socket.getInetAddress() + ":正在下载：" + file1.getName());

            //根据客户端发送过来的file对象去磁盘读取文件
            FileInputStream fileInputStream = new FileInputStream(file1);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);

            //获取服务端向客户端写数据的输出流
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream());


            //边读边写，详单与通过服务端，将客户端和磁盘连接在一起


            //一次输出1m 提高下载速度
            byte[] bytes = new byte[1024 * 1024];
            int length;
            while ((length = bufferedInputStream.read(bytes)) != -1) {
                bufferedOutputStream.write(bytes, 0, length);
                bufferedOutputStream.flush();
            }

            //回收资源
            bufferedInputStream.close();
            fileInputStream.close();
            socket.shutdownOutput();
            socket.shutdownInput();

            System.out.println(socket.getInetAddress() + ":下载已完成");

        }
    }
}
