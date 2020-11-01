package com.asn.se.thread;

/**
 * @Author: wangsen
 * @Date: 2020/11/1 13:52
 * @Description: 需求：启动三个线程，同时售卖100张票。
 * 为什么会出现相同的票和0票以及负数票？
 **/
public class SaleTicketsByRunnable implements Runnable {
    private int tickets = 100;
    private Object lock = new Object();

    public static void main(String[] args) {
        SaleTicketsByRunnable runnable = new SaleTicketsByRunnable();
        Thread thread1 = new Thread(runnable, "窗口1");
        Thread thread2 = new Thread(runnable, "窗口2");
        Thread thread3 = new Thread(runnable, "窗口3");

        thread1.start();
        thread2.start();
        thread3.start();
    }

    @Override
    public void run() {
        while (tickets > 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lock) {
                /*if (tickets > 0){
                    System.out.println(Thread.currentThread().getName() + "卖出第 " + tickets--+" 张票");
                }*/
                System.out.println(Thread.currentThread().getName() + "卖出第 " + tickets-- + " 张票");
            }
        }
    }
}
