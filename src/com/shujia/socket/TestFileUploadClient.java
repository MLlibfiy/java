package com.shujia.socket;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * 文件上传，客户端
 */
public class TestFileUploadClient {
    public static void main(String[] args) throws Exception {

        /**
         *
         * 选择需要上传的文件
         *
         */
        File file = new File("E:\\upload");
        File[] files = file.listFiles();
        System.out.println("请选择需要上传的文件");
        for (int i = 0; i < files.length; i++) {
            System.out.println(i + 1 + ":" + files[i].getName());
        }

        Scanner scanner = new Scanner(System.in);
        int index = 0;
        while (!(index <= files.length && index > 0)) {
            System.out.println("请选择你要下载的文件：");
            //获取需要下载的文件序号
            index = scanner.nextInt();
        }
        //获取需要上传的文件
        File uploadFIle = files[index - 1];

        //和服务器建立连接
        Socket socket = new Socket("localhost", 8888);

        /**
         * 上传文件之前告诉服务端上传文件的名字和类型
         */
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
        objectOutputStream.writeUTF(uploadFIle.getName());
        objectOutputStream.flush();


        BufferedOutputStream outputStream = new BufferedOutputStream(socket.getOutputStream());
        //读取需要上传的文件，同时上传个服务器
        FileInputStream in = new FileInputStream(uploadFIle);
        BufferedInputStream inputStream = new BufferedInputStream(in);

        System.out.println("文件开始上传.....");
        byte[] bytes = new byte[1024];
        int length;
        while ((length = inputStream.read(bytes)) != -1) {
            outputStream.write(bytes, 0, length);
            outputStream.flush();
        }
        System.out.println("文件上传完成");

        inputStream.close();
        in.close();
        socket.shutdownOutput();

    }
}
