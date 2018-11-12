package com.shujia.thread;

public class Demo1 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("主线程....");

        //创建线程对象，对象里面包好了一堆业务逻辑，对象可以在网络里面传输
        TestThreadDemo1 threadDemo1 = new TestThreadDemo1();

        //线程优先级，一共有0-10个级别，默认是5
        //优先级高不一定就会先执行，只是竞争到资源的可能性更高了
        threadDemo1.setPriority(10);

        //启动线程，线程会执行run方法
        threadDemo1.start();

        for (int i = 1; i <= 10; i++) {

            System.out.println("第" + i + "次执行main方法");
        }

    }
}
