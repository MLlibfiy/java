package com.shujia.thread;

/**
 * 打印1-100之前的偶数
 */
public class Demo3 {
    public static void main(String[] args) {
        System.out.println("主线程");
        PointOuShu ouShu = new PointOuShu();
        ouShu.start();

        //判断线程是否在运行
        System.out.println(ouShu.isAlive());

        //Thread.currentThread() 获取当前线程对象
        String name1 = Thread.currentThread().getName();
        System.out.println("主线程名：" + name1);
        //获取线程名
        String name = ouShu.getName();
        System.out.println(name);
        System.out.println(new PointOuShu().getName());
        System.out.println(new PointOuShu().getName());
        System.out.println(new PointOuShu().getName());

        //获取线程优先级.getPriority()
        System.out.println(Thread.currentThread().getPriority());
        System.out.println(ouShu.getPriority());

        //设置线程优先级,0-10
        ouShu.setPriority(7);



    }
}


class PointOuShu extends Thread {
    @Override
    public void run() {

        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }
    }
}
