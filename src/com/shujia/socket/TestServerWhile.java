package com.shujia.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * qq聊天
 * <p>
 * 服务端
 */
public class TestServerWhile {
    public static void main(String[] args) throws Exception {

        //创建服务端socket对象
        ServerSocket serverSocket = new ServerSocket(8888);
        System.out.println("服务端已启动");
        Socket socket = serverSocket.accept();
        while (true){

            /**
             * 接收消息
             *
             */
            //处于等待状态，等待客服端请求

            InputStream in = socket.getInputStream();
            InputStreamReader reader = new InputStreamReader(in);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line = bufferedReader.readLine();
            //socket.getInetAddress() 获取客户端的ip
            System.out.println(socket.getInetAddress()+"：" + line);


            /**
             * 回消息
             *
             */

            OutputStream out = socket.getOutputStream();
            OutputStreamWriter writer = new OutputStreamWriter(out);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);

            //键盘输入需要发送的消息
            System.out.print("请输入：");
            Scanner scanner = new Scanner(System.in);
            String msg = scanner.nextLine();

            bufferedWriter.write(msg);
            bufferedWriter.newLine();
            //舒勇缓冲流，每次需要刷新一下
            bufferedWriter.flush();
        }
    }

}
