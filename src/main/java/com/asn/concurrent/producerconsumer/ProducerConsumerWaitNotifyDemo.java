package com.asn.concurrent.producerconsumer;

import java.util.concurrent.*;

/**
 * @Author: wangsen
 * @Date: 2021/1/26 9:53
 * @Description: 生产者消费者，利用wait和notify实现。一个生产者和一个消费者，生产者生成产品，消费者消费产品，仓库最大容纳10个产品，仓库满了则生产者阻塞，仓库为空则消费者阻塞。
 * synchronized用法：
 * 1) 用在静态方法上：锁住的是class对象，也就是这个类所有的实例对象在调用这个方法时都需要争夺同一把对象，
 * 2) 用在实例方法上：锁住的是当前实例对象，也就是当有多个线程调用这个实例的这个方法时，都需要争夺同一把对象。
 * 3) 用在代码块上：用在代码块上比较灵活，有多种形式。比如：
 * 1) synchronized(this)：同2类似，也是锁当前实例对象
 * 2) synchronized(obj)：也是锁对象，只不过是自定义的一个对象
 * 3) synchronized(xxx.class)：同1类似，锁住的是一个类class对象，但此时使用notify、wait等时，需要在前面加上xxx.class来显式指定调用的是对象监视器的notify和wait方法。否则会
 * 报 IllegalMonitorStateException 异常（如果当前线程不是对象监视器的所有者）。
 **/
public class ProducerConsumerWaitNotifyDemo {
    public static void main(String[] args) {
        ProductBufferInterface buffer = new ProductBuffer();
        new Thread(new Producer(buffer)).start();
        new Thread(new Consumer(buffer)).start();
    }
}

//生产者线程
class Producer implements ProducerInterface, Runnable {
    private ProductBufferInterface buffer;

    public Producer(ProductBufferInterface buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (true) {
            Product product = new Product();
            buffer.put(product);
        }
    }
}

//消费者线程
class Consumer implements ConsumerInterface, Runnable {
    private ProductBufferInterface buffer;

    public Consumer(ProductBufferInterface buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (true) {
            Product product = buffer.get();
        }
    }
}

//带子消费者线程的消费者线程
class ConsumerWithSub implements Runnable {
    private ProductBufferInterface buffer;

    public ConsumerWithSub(ProductBufferInterface buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (true) {
            String res = buffer.getWithSubThread();
            System.out.println(Thread.currentThread().getName() + "---" + res);
        }
    }
}

//产品缓冲区对象
class ProductBuffer implements ProductBufferInterface {
    private final Product[] buffer;
    private static final int DEFAULTSIZE = 10;
    private int index;
    //开启5个子线程并行消费
    private static final ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 5, 0, TimeUnit.MICROSECONDS, new LinkedBlockingQueue<Runnable>(10));
    public ProductBuffer() {
        this(DEFAULTSIZE);
    }

    public ProductBuffer(int size) {
        this.buffer = new Product[size];
    }

    //添加产品
    public void put(Product product) {
        synchronized (ProductBuffer.class) {
            while (buffer.length == index) {
                try {
                    ProductBuffer.class.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            buffer[index++] = product;
            System.out.println("生产者线程：" + Thread.currentThread().getId() + " 生产第 " + index + " 个产品");
            ProductBuffer.class.notify();
        }
    }

    //消费产品
    public Product get() {
        synchronized (ProductBuffer.class) {
            while (index == 0) {
                try {
                    ProductBuffer.class.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("消费者线程：" + Thread.currentThread().getId() + " 消费第 " + index + " 个产品");
            ProductBuffer.class.notify();
            return buffer[--index];
        }
    }

    //开启多个子线程消费后合并数据
    public String getWithSubThread() {
        synchronized (ProductBuffer.class) {
            while (index == 0) {
                try {
                    ProductBuffer.class.wait();
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
            ProductBuffer.class.notify();
            return s1 + s2 + s3 + s4 + s5 + ",消费第 " + (index--) + " 个产品";
        }
    }
}

//产品
class Product {

}