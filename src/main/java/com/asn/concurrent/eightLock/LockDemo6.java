package com.asn.concurrent.eightLock;

import java.util.concurrent.TimeUnit;

/**
 * @Author: wangsen
 * @Date: 2021/1/27 17:22
 * @Description: synchronized如果修饰的是static类型的方法或对象，那么锁住的就是对应的class对象，全局唯一（就算是new了多个对象，它们使用的也是同一把锁）。
 * synchronized修饰的非static的对象，则锁住的就是对应的对象。和class锁之间是相互独立的两把锁，互相之间不影响。
 **/
public class LockDemo6 {
    public static void main(String[] args) throws InterruptedException {
        Phone6 phone6 = new Phone6();
        new Thread(() -> {
            try {
                phone6.sendEmail();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "A").start();

        TimeUnit.SECONDS.sleep(1);
        new Thread(() -> {
            phone6.callPhone();
        }, "B").start();
    }
}

class Phone6 {
    public static synchronized void sendEmail() throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
        System.out.println("sendEmail");
    }

    public synchronized void callPhone() {
        System.out.println("callPhone");
    }
}