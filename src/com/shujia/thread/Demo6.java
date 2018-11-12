package com.shujia.thread;

/**
 * 线程安全性问题
 */
public class Demo6 {
    public static void main(String[] args) {
        TicketTest test = new TicketTest();

        new Thread(test).start();
        new Thread(test).start();
        new Thread(test).start();
    }
}

class TicketTest implements Runnable {
    //共享变量
    private int ticket = 1000;

    @Override
    public void run() {
        while (true) {
            //同步代码块，同一时刻只能有一个线程执行，其他线程处于阻塞状态
            synchronized (this) {
                if (ticket > 0) {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Thread thread = Thread.currentThread();
                    ticket--;
                    System.out.println(thread.getName() + ";" + ticket);
                }
            }
        }

    }
}
