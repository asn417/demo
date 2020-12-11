package com.asn.designpattern.observer;

/**
 * @Author: wangsen
 * @Date: 2020/12/11 12:18
 * @Description: 观察者模式：一旦被观察者做了某些事，就立即通知被观察者（push消息的模式），因此被观察者对象中需要维护有哪些观察者订阅了它，并且被观察者对象还需要
 * 在做了某些事时通知观察者。
 **/
public class ObserverPattern {
    public static void main(String[] args) {
        //创建一个被观察者
        Subject subject = new ConcreteSubject();
        Subject subject1 = new ConcreteSubject1();
        //创建一个观察者
        Observer observer = new ConcreteObserver();
        Observer observer1 = new ConcreteObserver1();
        //将观察者维护到被观察者中
        subject.addObserver(observer);
        subject1.addObserver(observer1);
        //被观察者做了某些事
        subject.doSomething();
        subject1.doSomething();
    }
}
