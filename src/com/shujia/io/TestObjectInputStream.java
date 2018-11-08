package com.shujia.io;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

/**
 *
 *对象输入流
 */
public class TestObjectInputStream {
    public static void main(String[] args) throws Exception{
        FileInputStream in = new FileInputStream("E:\\tmp\\user.txt");

        ObjectInputStream objectInputStream = new ObjectInputStream(in);

        //对象流在读取的时候，需要按写入顺序读取
        Person p = (Person)objectInputStream.readObject();
        System.out.println(p);

        boolean b = objectInputStream.readBoolean();
        System.out.println(b);

        String s = objectInputStream.readUTF();
        System.out.println(s);

        ArrayList<User> arrayList = (ArrayList<User>)objectInputStream.readObject();

        for (User user : arrayList) {
            System.out.println(user);
        }

        objectInputStream.close();
        in.close();

    }
}
