package com.shujia.io;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class StudentInfo {
    /**
     * 从文件中读取学生信息
     *
     * @return
     * @throws Exception
     */
    public static  ArrayList<Student> read()throws Exception{
        //1、使用字节流读取数据
        FileInputStream in = new FileInputStream("E:\\bigdata\\java\\data\\students.txt");
        //2、将字节流转字符流，指定文件编码方式
        InputStreamReader streamReader = new InputStreamReader(in,"UTF-8");
        //3、将字符流转换成字符缓冲流，为了按行读取
        BufferedReader bufferedReader = new BufferedReader(streamReader);

        //存放学生的集合
        ArrayList<Student> students = new ArrayList<>();

        String line ;
        while ((line=bufferedReader.readLine())!=null){
            String[] split = line.split(",");
            //构建学生对象
            Student student = new Student(split[0], split[1], Integer.parseInt(split[2]), split[3], split[4]);
            students.add(student);
        }
        bufferedReader.close();
        streamReader.close();
        in.close();

        return students;

    }
}
