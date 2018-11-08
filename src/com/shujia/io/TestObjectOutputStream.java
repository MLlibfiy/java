package com.shujia.io;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * 对象输出流
 *
 *
 * 程序---->文件的过程称为序列化
 * 文件---->程序的过程称为反序列化
 */
public class TestObjectOutputStream {
    public static void main(String[] args) throws Exception{
        //创建字节输出流
        FileOutputStream out = new FileOutputStream("E:\\tmp\\user.txt");
        //将字节输出流转换成对象输出流
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(out);

        Person person = new Person("张三", 23);

        //输出的类型需要实现Serializable接口
        objectOutputStream.writeObject(person);
        objectOutputStream.writeBoolean(true);
        objectOutputStream.writeUTF("我爱数加");

        User user = new User("张三",23,"男");
        User user1 = new User("李四",23,"男");
        User user2 = new User("王五",23,"男");
        ArrayList<User> users = new ArrayList<>();
        users.add(user);
        users.add(user1);
        users.add(user2);

        objectOutputStream.writeObject(users);

        objectOutputStream.close();
        out.close();



    }
}

