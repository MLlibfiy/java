package com.shujia.thread;

/**
 * 通过实现接口实现多线程
 *
 */
public class TestRunnable implements Runnable {

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println("第" + i + "次执行run方法");
        }
    }
}
