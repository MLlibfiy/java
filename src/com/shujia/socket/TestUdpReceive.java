package com.shujia.socket;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 *
 * 接收端
 */
public class TestUdpReceive {
    public static void main(String[] args) throws Exception{
        //创建接收数据报包的对象，绑定一个端口
        DatagramSocket socket = new DatagramSocket(9999);

        //创建空的数据报包对象
        byte[] bytes = new byte[1024];
        DatagramPacket packet = new DatagramPacket(bytes, bytes.length);

        //将接收过来的数据放入创建的这个空的数据报包对象中
        socket.receive(packet);

        //拆包，将接收过来的数据构建成一个字符串
        String data = new String(packet.getData(), 0, packet.getLength());

        System.out.println(data);

        socket.close();
    }

}
