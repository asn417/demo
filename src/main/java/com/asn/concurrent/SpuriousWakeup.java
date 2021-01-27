package com.asn.concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: wangsen
 * @Date: 2021/1/27 13:55
 * @Description: 虚假唤醒
 * 在多线程的情况下，当多个线程执行了wait()方法后，需要其它线程执行notify()或者notifyAll()方法去唤醒，
 * 假如被阻塞的多个线程都被唤醒，但实际情况是被唤醒的线程中有一部分线程是不应该被唤醒的，那么对于这些不应该被唤醒的线程而言就是虚假唤醒。
 * <p>
 * 虚假唤醒，指的就是不应该唤醒的被唤醒了。
 * <p>
 * 避免的办法是，将if判断改成while
 **/
public class SpuriousWakeup {
    public static void main(String[] args) {
        Product product = new Product();
        new Thread(() -> {
            try {
                for (int i = 0; i < 200; i++) {
                    product.put();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "A").start();
        new Thread(() -> {
            try {
                for (int i = 0; i < 100; i++) {
                    product.get();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "B").start();
        new Thread(() -> {
            try {
                for (int i = 0; i < 100; i++) {
                    product.get();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "C").start();
    }
}

class Product {
    private int num;
    private final Lock lock = new ReentrantLock();
    private Condition getLock = lock.newCondition();
    private Condition setLock = lock.newCondition();

    public void get() throws InterruptedException {
        lock.lock();
        try {
            if (num == 0) {//改成while即可避免虚假唤醒
                getLock.await();
            }
            num--;
            System.out.println(Thread.currentThread().getName() + "消费了数据:" + num);
            setLock.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void put() throws InterruptedException {
        lock.lock();
        try {
            if (num != 0) {//改成while即可避免虚假唤醒
                setLock.await();
            }
            num++;
            System.out.println(Thread.currentThread().getName() + "生产了数据:" + num);
            getLock.signalAll();
        } finally {
            lock.unlock();
        }
    }
}

