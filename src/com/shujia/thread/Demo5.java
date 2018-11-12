package com.shujia.thread;

/**
 * 交替打印
 */
public class Demo5 {
    public static void main(String[] args) {
        Threan1 threan1 = new Threan1();
        Threan2 threan2 = new Threan2();

        threan1.start();
        threan2.start();

    }
}

class Threan1 extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <=10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Thread thread = Thread.currentThread();
            System.out.println(thread.getName() + ":" + i);

        }
    }
}

class Threan2 extends Thread {
    @Override
    public void run() {
        for (int i = 10; i > 0; i--) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Thread thread = Thread.currentThread();
            System.out.println(thread.getName() + ":" + i);

        }
    }
}


