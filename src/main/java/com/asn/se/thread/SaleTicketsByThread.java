package com.asn.se.thread;

/**
 * @Author: wangsen
 * @Date: 2020/11/1 12:49
 * @Description: 需求：启动三个线程，同时售卖100张票。
 * 这是线程安全的么？打印的第一条一定是100么？
 * 这里虽然用了synchronized，但加的锁是this，也就是各自线程自己的锁，因此跟不加锁是一个效果，所以是线程不安全的。
 **/
public class SaleTicketsByThread extends Thread {
    private static int tickets = 100;

    private static Object lock = new Object();

    public static void main(String[] args) {
        SaleTicketsByThread thread1 = new SaleTicketsByThread();
        SaleTicketsByThread thread2 = new SaleTicketsByThread();
        SaleTicketsByThread thread3 = new SaleTicketsByThread();

        thread1.setName("窗口1");
        thread2.setName("窗口2");
        thread3.setName("窗口3");
        thread1.start();
        thread2.start();
        thread3.start();

    }

    @Override
    public void run() {
        while (tickets > 0) {//循环定义在同步代码快之外，这样没卖完一张票就会释放锁，然后三个线程重新竞争锁售卖下一张票
            synchronized (lock) {//这里应该使用同一把锁，也就是上面定义的lock
                if (tickets > 0) {
                    System.out.println(Thread.currentThread().getName() + "卖出第 " + tickets-- + " 张票");
                }
            }
        }
    }
    //错误写法一
    /*@Override
    public void run(){
        synchronized (this) {//这个this对应的是各自的对象，不是同一把锁，因此无意义
            while (tickets > 0) {
                System.out.println(Thread.currentThread().getName() + "卖出第 " + tickets-- + " 张票");
            }
        }
    }*/

    //错误写法二
    /*@Override
    public void run(){
        synchronized (lock) {
            while (tickets > 0) {//上面虽然使用了同一把锁，但这里用了循环，也就是一旦某个线程拿到了锁，那就会一直运行知道结束，也失去了多线程的意义
                System.out.println(Thread.currentThread().getName() + "卖出第 " + tickets-- + " 张票");
            }
        }
    }*/
}
