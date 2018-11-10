package com.shujia.socket;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 文件上传服务端
 */
public class TestFileupLoadServer {
    public static void main(String[] args) throws Exception {

        String homePath = "E:\\tmp\\";

        ServerSocket serverSocket = new ServerSocket(8888);

        System.out.println("服务端已启动....");
        //等待客户端上传数据
        Socket accept = serverSocket.accept();
        /**
         * 获取文件名
         *
         */
        ObjectInputStream objectInputStream = new ObjectInputStream(accept.getInputStream());
        String fileName = objectInputStream.readUTF();

        //读取客户端上传的数据
        BufferedInputStream inputStream = new BufferedInputStream(accept.getInputStream());
        FileOutputStream out = new FileOutputStream(homePath + fileName);
        BufferedOutputStream outputStream = new BufferedOutputStream(out);

        byte[] bytes = new byte[1024];
        int length;
        while ((length = inputStream.read(bytes)) != -1) {
            outputStream.write(bytes, 0, length);
            outputStream.flush();
        }
        outputStream.close();
        out.close();
        accept.shutdownInput();


    }
}
