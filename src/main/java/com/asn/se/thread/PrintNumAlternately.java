package com.asn.se.thread;

/**
 * @Author: wangsen
 * @Date: 2020/11/1 15:44
 * @Description: 需求：两个线程交替打印1到100，也就是一个线程只打印奇数，另一个线程只打印偶数
 **/
public class PrintNumAlternately implements Runnable {

    private Object lock = new Object();
    private int num = 1;
    private Boolean flag = true;

    public static void main(String[] args) {
        PrintNumAlternately printNumAlternately = new PrintNumAlternately();
        new Thread(printNumAlternately, "奇数").start();
        new Thread(printNumAlternately, "偶数").start();
    }

    @Override
    public void run() {
        while (num <= 100) {
            synchronized (lock) {
                if (flag && "奇数".equals(Thread.currentThread().getName())) {
                    System.out.println(Thread.currentThread().getName() + ":" + num++);
                    flag = false;
                    try {
                        lock.notifyAll();
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else if (flag && "偶数".equals(Thread.currentThread().getName())) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println(Thread.currentThread().getName() + ":" + num++);
                    try {
                        lock.notifyAll();
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //如果没有下面这段代码，那么程序会一直阻塞不会结束。因为最后的奇数线程处于wait状态。
                if (num == 101) {
                    lock.notifyAll();
                }
            }
        }
    }
}
