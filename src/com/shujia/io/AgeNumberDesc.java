package com.shujia.io;

import java.util.*;

/**
 * 统计每个年龄的人数，按照人数倒序排序
 * <p>
 * 23，56
 * 21，40
 */
public class AgeNumberDesc {
    public static void main(String[] args) throws Exception {
        //学生信息表
        ArrayList<Student> students = StudentInfo.read();


        HashMap<Integer, Integer> ageMap = new HashMap<>();

        for (Student student : students) {
            Integer age = student.getAge();
            Integer number = ageMap.get(age);
            if (number == null) {
                ageMap.put(age, 1);
            } else {
                ageMap.put(age, number + 1);
            }
        }

        ArrayList<String> list = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : ageMap.entrySet()) {
            list.add(entry.getKey() + "," + entry.getValue());
        }

        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                Integer n1 = Integer.parseInt(o1.split(",")[1]);
                Integer n2 = Integer.parseInt(o2.split(",")[1]);

                return n2 - n1;
            }
        });

        for (String s : list) {
            System.out.println(s);
        }


    }
}
