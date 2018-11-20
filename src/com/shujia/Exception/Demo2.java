package com.shujia.Exception;

import java.io.FileInputStream;
import java.io.IOException;

public class Demo2 {
    public static void main(String[] args) throws MyException {


        try {
            th(null);

        } catch (MyException e) {

            e.printStackTrace();//打印堆栈信息，错误信息

            //catch里面也可以抛异常
            throw new MyException();

        }

    }

    /**
     * throws Exception  抛出异常，抛给调用者
     *
     * @param name
     * @throws Exception
     */

    public static  void th(String name) throws MyException {
        if (name == null) {
            //抛出异常后，后面的代码不会再执行
            throw new MyException("名字不能为空");
        }

        System.out.println(name);
    }
}
