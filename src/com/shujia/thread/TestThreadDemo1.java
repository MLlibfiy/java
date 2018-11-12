package com.shujia.thread;

/**
 * 通过继承thread类实现多线程
 * 重写run方法
 */
public class TestThreadDemo1 extends Thread {

    /**
     *
     * 重写run方法，当线程启动之后会执行run方法里面的代码
     */
    @Override
    public void run() {

        for (int i = 1; i <= 10; i++) {

            try {
                //使当前线程沉睡1000毫秒
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("第" + i + "次执行run方法");
        }

    }
}
