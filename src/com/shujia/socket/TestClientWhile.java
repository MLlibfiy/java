package com.shujia.socket;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 *qq聊天
 * 客户端
 *
 */
public class TestClientWhile {
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("localhost", 8888);
        System.out.println("连接成功........");
        while (true){
            //发消息
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
            //socket.shutdownOutput();

            /**
             * 接收消息
             */

            InputStream in = socket.getInputStream();
            InputStreamReader reader = new InputStreamReader(in);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line = bufferedReader.readLine();
            //socket.getInetAddress() 获取客户端的ip
            System.out.println(socket.getInetAddress()+"：" + line);
            //socket.shutdownInput();

        }
    }
}
