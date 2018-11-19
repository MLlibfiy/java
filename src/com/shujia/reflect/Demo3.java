package com.shujia.reflect;

import java.util.ArrayList;

public class Demo3 {
    public static void main(String[] args) {

        ArrayList<Student> load = DataUtil.load("E:\\bigdata\\java\\data\\score.txt",Student.class);

        for (Student student : load) {
            System.out.println();
        }

    }
}
