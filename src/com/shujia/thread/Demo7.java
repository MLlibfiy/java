package com.shujia.thread;

public class Demo7 {
    public static void main(String[] args) {
        Account account = new Account(10000);
        Draw draw = new Draw(account);

        Thread thread = new Thread(draw);
        thread.setName("张三");//设置线程名

        Thread thread2 = new Thread(draw);
        thread2.setName("张三的妻子");//设置线程名

        thread.start();
        thread2.start();


    }
}


class Draw implements Runnable {

    //共享变量
    private Account account;

    public Draw(Account account) {
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
                    System.out.println(thread.getName() + "取走10:" + "  剩余金额为：" + account.getBalance());
                } else {
                    System.out.println(thread.getName() + "取钱：余部不足");
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