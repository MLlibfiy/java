package com.shujia.socket;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * 群发消息
 */
public class TestUdpWhile {
    public static void main(String[] args)throws Exception {
        for (int i = 2; i < 256; i++) {

            String ip = "192.168.0." + i;
            InetAddress inetAddress = InetAddress.getByName(ip);

            DatagramSocket socket = new DatagramSocket();

            byte[] bytes = "明天自习".getBytes();
            DatagramPacket packet = new DatagramPacket(bytes, 0, bytes.length, inetAddress, 9999);

            socket.send(packet);

            socket.close();
        }
    }
}
