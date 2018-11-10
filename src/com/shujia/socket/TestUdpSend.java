package com.shujia.socket;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * 发送端
 *
 */
public class TestUdpSend {
    public static void main(String[] args) throws Exception{
        //创建发送数据报包的对象（相当与发送器）
        DatagramSocket socket = new DatagramSocket();

        byte[] bytes = "我爱数加".getBytes();

        //构建数据报包(相当于一条短信，包含短信内容和对方的号码)
        DatagramPacket packet = new DatagramPacket(bytes, 0, bytes.length,
                InetAddress.getByName("localhost"), 9999);

        //发送数据报包，数据报包会被发送到交换机，由交换机转发
        socket.send(packet);

        socket.close();

    }
}
