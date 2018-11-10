package com.shujia.socket;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * 文件下载客户端
 */
public class TestFIleDownLoadClient {

    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost", 8888);
        InputStream in = socket.getInputStream();
        ObjectInputStream inputStream = new ObjectInputStream(in);
        File[] files = (File[]) inputStream.readObject();

        //这里不能关，因为后面还要下载文件
        //socket.shutdownInput();

        System.out.println("可以下载的文件列表");
        for (int i = 0; i < files.length; i++) {
            System.out.println(i + 1 + ":" + files[i].getName());
        }

        int index = 0;
        while (!(index <= files.length && index > 0)) {
            System.out.println("请选择你要下载的文件：");
            Scanner scanner = new Scanner(System.in);
            //获取需要下载的文件序号
            index = scanner.nextInt();
        }

        System.out.println("开始下载文件");

        //根据输入的索引获取需要下载的文件
        File file = files[index - 1];
        ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
        outputStream.writeObject(file);
        outputStream.flush();
        BufferedInputStream bufferedInputStream = new BufferedInputStream(socket.getInputStream());
        FileOutputStream fileOutputStream = new FileOutputStream("E:\\upload\\" + file.getName());
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);

        /**
         * 边读边写
         *
         */
        byte[] bytes = new byte[1024 * 1024];
        int length;
        while ((length = bufferedInputStream.read(bytes)) != -1) {
            bufferedOutputStream.write(bytes,0,length);
            bufferedOutputStream.flush();

        }

        bufferedOutputStream.close();
        fileOutputStream.close();
        socket.shutdownInput();
        socket.shutdownOutput();



    }
}
