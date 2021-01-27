package com.asn.concurrent.eightLock;

/**
 * @Author: wangsen
 * @Date: 2021/1/27 17:13
 * @Description: synchronized加在方法上，表示对象监视器是当前对象this，也就是锁的是this。因此sendEmail和callPhone争抢的是同一把锁this，谁先抢到谁先执行。
 * https://www.cnblogs.com/itiaotiao/p/12651573.html
 **/
public class LockDemo1 {
    public static void main(String[] args) throws InterruptedException {
        Phone1 phone1 = new Phone1();
        new Thread(() -> {
            phone1.sendEmail();
        }, "A").start();
        new Thread(() -> {
            phone1.callPhone();
        }, "B").start();
    }
}

class Phone1 {
    public synchronized void sendEmail() {
        System.out.println("senEmail");
    }

    public synchronized void callPhone() {
        System.out.println("callPhone");
    }
}
