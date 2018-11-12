package com.shujia.thread;

public class Demo1 {
    public static void main(String[] args){
        System.out.println("主线程....");

        //创建线程对象
        TestThreadDemo1 threadDemo1 = new TestThreadDemo1();

        //启动线程，线程会执行run方法
        threadDemo1.start();

        for (int i = 1; i <= 10; i++) {
            System.out.println("第" + i + "次执行main方法");
        }

    }
}
