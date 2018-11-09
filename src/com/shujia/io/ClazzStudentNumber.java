package com.shujia.io;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 统计每个班级的人数
 * 1、读取班级信息表（学号，姓名，年龄，写别，班级）
 * 2、统计每个班级学生人数
 * 3、将结果写入到文件（班级名，人数）
 */
public class ClazzStudentNumber {
    public static void main(String[] args)throws Exception {

        //调用封装好的读取学生信息的方法
        ArrayList<Student> students = StudentInfo.read();

        /**
         * 统计班级人数
         *
         */

        //存放班级人数
        HashMap<String, Integer> numberMap = new HashMap<>();

        for (Student  student : students) {
            String clazz = student.getClazz();
            //第一次进来，Integer==null,说明这个班级还没有学生
            Integer integer = numberMap.get(clazz);
            if (integer==null){
                numberMap.put(clazz,1);
            }else {
                int i = integer + 1;
                //覆盖之前统计的人数
                numberMap.put(clazz,i);
            }
        }

        //将结果保存到文件
        FileWriter writer = new FileWriter("E:\\bigdata\\java\\out\\studentNumber.txt");

        BufferedWriter bufferedWriter = new BufferedWriter(writer);

        Set<Map.Entry<String, Integer>> entries = numberMap.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            bufferedWriter.write(entry.getKey()+","+entry.getValue());
            bufferedWriter.newLine();
            bufferedWriter.flush();
        }

        bufferedWriter.close();
        writer.close();

    }
}
