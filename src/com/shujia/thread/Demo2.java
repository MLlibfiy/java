package com.shujia.thread;

public class Demo2 {
    public static void main(String[] args) {

        //创建线程对象-----初生状态
        TestRunnable runnable = new TestRunnable();
        Thread thread = new Thread(runnable);

        //线程进入就绪状态--有资格无资源
        //如果竞争到资源进入运行状态---有资源有资格
        thread.start();


        for (int i = 1; i <= 10; i++) {
            System.out.println("第" + i + "次执行main方法");
        }


    }
}
