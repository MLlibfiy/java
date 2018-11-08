package com.shujia.io;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Demo8 {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入学生的名字：");
        String name = scan.next();
        System.out.println("请输入学生的年龄：");
        int age = scan.nextInt();
        System.out.println("请选择学生的性别：1：男，2：女");
        HashMap<Integer, String> genderMap = new HashMap<>();
        genderMap.put(1,"男");
        genderMap.put(2,"女");
        int flag = scan.nextInt();
        String gender = genderMap.get(flag);
        User user = new User(name, age, gender);
        System.out.println(user);
        FileWriter writer = new FileWriter("E:\\tmp\\user.txt");
        writer.write(user.makeStr());
        writer.close();

    }


}

/**
 * 用户类
 *
 */
class User{
    String name;
    int age;
    String gender;

    public User() {
    }

    public User(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }


    public String makeStr(){
        return name+","+age+","+gender;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
