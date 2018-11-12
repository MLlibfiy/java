package com.shujia.thread;

import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;

/**
 * 客户端
 * 创建线程
 */
public class TestThreanClient {
    public static void main(String[] args) throws Exception {
        MyThread myThread = new MyThread();
        myThread.setName("客户端");
        myThread.setPriority(10);

        //创建连接
        Socket socket = new Socket("localhost", 9999);

        //获取输出流
        ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
        outputStream.writeObject(myThread);
        outputStream.flush();

        socket.shutdownOutput();

    }

}

class MyThread extends Thread implements Serializable {
    @Override
    public void run() {
        System.out.println("客户端发送过来的线程对象");
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + ":" + i);
        }
    }
}
