package com.shujia.thread;

public class Demo7 {
    public static void main(String[] args) {
        Account account = new Account(10000);

        ZhangSan zhangSan = new ZhangSan(account);
        Wife wife = new Wife(account);

        Thread thread = new Thread(zhangSan);
        Thread thread2 = new Thread(wife);


        thread.start();
        thread2.start();


    }
}


class ZhangSan implements Runnable {

    //共享变量
    private Account account;

    public ZhangSan(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        Thread thread = Thread.currentThread();
        while (true) {
            synchronized (account){
                if (account.getBalance() > 0) {

                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    int balance = account.getBalance();
                    balance = balance - 10;
                    account.setBalance(balance);
                    System.out.println("张三取走10:" + "  剩余金额为：" + account.getBalance());
                } else {
                    System.out.println( "张三取钱：余部不足");
                    thread.stop();
                }
            }
        }
    }
}


class Wife implements Runnable{
    //共享变量
    private Account account;

    public Wife(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        Thread thread = Thread.currentThread();
        while (true) {
            synchronized (account){
                if (account.getBalance() > 0) {

                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    int balance = account.getBalance();
                    balance = balance - 10;
                    account.setBalance(balance);
                    System.out.println("妻子取走10:" + "  剩余金额为：" + account.getBalance());
                } else {
                    System.out.println("妻子取钱：余部不足");
                    thread.stop();
                }
            }
        }
    }
}

/**
 * 银行账户类
 */
class Account {
    //余额
    private int balance;

    public Account() {
    }

    public Account(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}