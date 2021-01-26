package com.asn.concurrent.producerconsumer;

/**
 * @Author: wangsen
 * @Date: 2021/1/26 9:53
 * @Description: 生产者消费者，利用wait和notify实现。一个生产者和一个消费者，消费者每接收一条数据都启动5个子线程处理，并将处理结构合并后返回。
 **/
public class ProducerConsumerWaitNotifyDemo2 {
    public static void main(String[] args) {
        ProductBuffer buffer = new ProductBuffer();
        new Thread(new Producer(buffer)).start();
        new Thread(new ConsumerWithSub(buffer)).start();
    }
}
