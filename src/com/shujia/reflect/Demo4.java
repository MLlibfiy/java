package com.shujia.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class Demo4 {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        /**
         *
         * 泛型只在编译时起作用
         */
        ArrayList<Student> students = new ArrayList<>();
        Student student = new Student();
        students.add(student);
        //编译时异常，编译时检测
//        students.add("aaa");

        /**
         * 通过反射绕过泛型限制
         */
        Class aClass = students.getClass();
        Method method = aClass.getMethod("add", Object.class);
        method.invoke(students,"数加");
        for (Object s : students) {
            System.out.println(s);
        }


    }
}
