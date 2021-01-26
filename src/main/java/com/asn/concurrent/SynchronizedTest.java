package com.asn.concurrent;

/**
 * @Author: wangsen
 * @Date: 2021/1/26 11:45
 * @Description: 1、synchronized加在实例方法上，就相当于是synchronized(this)，锁住的是当前实例对象
 * 2、synchronized加在静态方法上，就相当于是synchronized(xxx.class)，锁住的是当前类
 * 3、synchronized加在代码块上，可以灵活的指定对象监视器
 * 4、synchronized的作用域只是被包围的部分代码，其他代码不受影响。下面的列子中，get方法使用的对象监视器是MyObj.class，那么创建的两个对象myObj和myObj1在不同线程中调用get方法时
 * 都需要争夺这把锁而导致只有一个线程运行。但set方法使用的是this锁（或不加锁），则不受MyObj.class锁的影响。
 **/
public class SynchronizedTest {
    public static void main(String[] args) {
        MyObj myObj = new MyObj();
        MyObj myObj1 = new MyObj();

        new Thread(() -> {
            myObj.get();
        }).start();
        new Thread(() -> {
            myObj.set();
        }).start();
        new Thread(() -> {
            myObj1.get();
        }).start();
        new Thread(() -> {
            myObj1.set();
        }).start();
    }
}

class MyObj {
    public void get() {
        synchronized (MyObj.class) {
            while (true) {
                System.out.println("thread：" + Thread.currentThread().getId() + ",get()");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void set() {
        synchronized (this) {
            while (true) {
                System.out.println("thread：" + Thread.currentThread().getId() + ",set()");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}