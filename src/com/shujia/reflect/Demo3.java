package com.shujia.reflect;

import java.util.ArrayList;

public class Demo3 {
    public static void main(String[] args) {

        ArrayList<Student> load = DataUtil.load("E:\\bigdata\\java\\data\\students.txt",Student.class);

        for (Student  s: load) {
            System.out.println(s);
        }

        ArrayList<Score> Scores = DataUtil.load("E:\\bigdata\\java\\data\\score.txt", Score.class);

        for (Score score : Scores) {
            System.out.println(score);
        }

    }
}
