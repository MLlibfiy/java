package com.shujia.Exception;


import java.io.IOException;

/**
 * 异常
 * 1、编译时异常
 * 异常很明确：代码写错了，少了一个冒号
 * 2、运行时异常
 */
public class Demo1 {
    public static void main(String[] args) {

        try {
            //可能发生异常的代码块
            int i = 10;
            int j = 0;
            System.out.println("异常发生前");
            int x = i / j;
            //出现异常后异常后面的代码块不会再执行
            System.out.println("异常发生后");

        }catch (Exception e){//捕获异常的类型
            //异常发生后执行的代码块
            System.out.println("catch...");

            //运行时异常
            //RuntimeException runtimeException = new RuntimeException();
        }finally {
            /**
             * 一般在finally 回收资源，io资源，网络资源
             *
             */

            //不管是否发生异常都会执行
            System.out.println("finally....");
        }


        System.out.println("异常");


    }
}
