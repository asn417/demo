package com.asn.concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: wangsen
 * @Date: 2021/1/25 17:56
 * @Description: 实现三个线程依次打印ABC
 **/
public class LockConditionTest1 {
    public static void main(String[] args) {
        final AlternateDemo ad = new AlternateDemo();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    ad.loopA();
                }
            }
        }, "A").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    ad.loopB();
                }
            }
        }, "B").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    ad.loopC();
                    System.out.println("-----------------------------------");
                }
            }
        }, "C").start();
    }
}

class AlternateDemo {
    private int number = 1; //当前正在执行线程的标记,相当于状态标记

    private Lock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();

    public void loopA() {
        lock.lock();
        try {
            //1. 判断
            if (number != 1) {
                condition1.await();
            }
            //2. 打印
            System.out.println(Thread.currentThread().getName());
            //3. 唤醒
            number = 2;
            condition2.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void loopB() {
        lock.lock();
        try {
            //1. 判断
            if (number != 2) {
                condition2.await();
            }
            //2. 打印
            System.out.println(Thread.currentThread().getName());
            //3. 唤醒
            number = 3;
            condition3.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void loopC() {
        lock.lock();
        try {
            //1. 判断
            if (number != 3) {
                condition3.await();
            }
            //2. 打印
            System.out.println(Thread.currentThread().getName());
            //3. 唤醒
            number = 1;
            condition1.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
