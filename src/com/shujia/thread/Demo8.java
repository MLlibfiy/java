package com.shujia.thread;

/**
 * 生产者消费者模式
 *
 */
public class Demo8 {

    public static void main(String[] args) {

        Goods goods = new Goods();
        goods.setFlag(false);//默认还没有商品

        Produce produce = new Produce(goods);
        Consumer consumer = new Consumer(goods);

        new Thread(produce).start();
        new Thread(consumer).start();


    }
}

class Consumer implements Runnable{

    private Goods goods;

    public Consumer(Goods goods) {
        this.goods = goods;
    }

    @Override
    public void run() {
        for (int i = 0; i <100 ; i++) {
            synchronized (goods){
                if (goods.isFlag()){//有商品才消费
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println("消费者消费了:"+goods.getBrand()+goods.getName());
                    goods.setFlag(false);//消费完了
                }

                goods.notify();//唤醒其他处于等待状态的线程

                try {
                    goods.wait();//使当前线程处于等待状态，直到其他线程唤醒
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

/**
 * 生产者
 *
 */

class Produce implements Runnable{

    private Goods goods;

    public Produce(Goods goods) {
        this.goods = goods;
    }

    @Override
    public void run() {
        for (int i = 0; i <100 ; i++) {
            synchronized (goods){
                if (!goods.isFlag()){//没有商品才生产
                    if (i%2==0){
                        goods.setBrand("哇哈哈");
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        goods.setName("矿泉水");
                    }else {
                        goods.setBrand("旺仔");
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        goods.setName("小馒头");
                    }
                    System.out.println("生产者生产了:"+goods.getBrand()+goods.getName());

                    goods.setFlag(true);
                }

                goods.notify();
                try {
                    goods.wait();//使当前线程处于等待状态，直到其他线程唤醒
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

/**
 * 商品类
 */
class Goods{
    private String brand;//品牌
    private String name;//商品名
    private boolean flag;//是否有商品

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public Goods() {
    }

    @Override
    public String toString() {
        return "Goods{" +
                "brand='" + brand + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public Goods(String brand, String name) {
        this.brand = brand;
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}