package com.asn.concurrent.producerconsumer;

import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: wangsen
 * @Date: 2021/1/26 15:08
 * @Description: 使用 lock 和 condition 实现生产者消费者模型
 *      signalAll会唤醒对应condition下所有wait的线程，而signal之后挑选一个唤醒。
 **/
public class ProducerConsumerLockConditionDemo {

    public static void main(String[] args) {
        ProductBufferInterface buffer = new ProductBuffer1();
        new Thread(new Producer(buffer)).start();
        new Thread(new ConsumerWithSub(buffer)).start();
    }
}

//产品缓冲区对象
class ProductBuffer1 implements ProductBufferInterface {
    private final Product[] buffer;
    private static final int DEFAULTSIZE = 10;
    private int index;
    //开启5个子线程并行消费
    private static final ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 5, 0, TimeUnit.MICROSECONDS, new LinkedBlockingQueue<Runnable>(20));

    private final Lock lock = new ReentrantLock();
    private Condition putCondition = lock.newCondition();
    private Condition getCondition = lock.newCondition();

    public ProductBuffer1() {
        this(DEFAULTSIZE);
    }

    public ProductBuffer1(int size) {
        this.buffer = new Product[size];
    }

    //添加产品
    public void put(Product product) {
        lock.lock();
        try {
            while (buffer.length == index) {
                try {
                    putCondition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            buffer[index++] = product;
            System.out.println("生产者线程：" + Thread.currentThread().getId() + " 生产第 " + index + " 个产品");
            getCondition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    //消费产品
    public Product get() {
        lock.lock();
        try {
            while (index == 0) {
                try {
                    getCondition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
            System.out.println("消费者线程：" + Thread.currentThread().getId() + " 消费第 " + index + " 个产品");
            putCondition.signal();
            return buffer[--index];
        } finally {
            lock.unlock();
        }
    }

    //开启多个子线程消费后合并数据
    public String getWithSubThread() {
        lock.lock();
        try {
            while (index == 0) {
                try {
                    getCondition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            Product product = buffer[index - 1];

            Future<String> subTask1 = executor.submit(() -> {
                System.out.println("消费者子线程：" + Thread.currentThread().getId() + " 消费第 " + index + " 个产品");
                return String.valueOf(Thread.currentThread().getId());
            });
            Future<String> subTask2 = executor.submit(() -> {
                System.out.println("消费者子线程：" + Thread.currentThread().getId() + " 消费第 " + index + " 个产品");
                return String.valueOf(Thread.currentThread().getId());
            });
            Future<String> subTask3 = executor.submit(() -> {
                System.out.println("消费者子线程：" + Thread.currentThread().getId() + " 消费第 " + index + " 个产品");
                return String.valueOf(Thread.currentThread().getId());
            });
            Future<String> subTask4 = executor.submit(() -> {
                System.out.println("消费者子线程：" + Thread.currentThread().getId() + " 消费第 " + index + " 个产品");
                return String.valueOf(Thread.currentThread().getId());
            });
            Future<String> subTask5 = executor.submit(() -> {
                System.out.println("消费者子线程：" + Thread.currentThread().getId() + " 消费第 " + index + " 个产品");
                return String.valueOf(Thread.currentThread().getId());
            });

            String s1 = null;
            String s2 = null;
            String s3 = null;
            String s4 = null;
            String s5 = null;
            try {
                s1 = subTask1.get();
                s2 = subTask2.get();
                s3 = subTask3.get();
                s4 = subTask4.get();
                s5 = subTask5.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            System.out.println("消费者线程：" + Thread.currentThread().getId() + " 消费第 " + index + " 个产品");
            putCondition.signalAll();
            return s1 + s2 + s3 + s4 + s5 + ",消费第 " + (index--) + " 个产品";
        } finally {
            lock.unlock();
        }
    }
}

