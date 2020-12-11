package com.asn.designpattern.observer;

import java.util.Vector;

/**
 * @Author: wangsen
 * @Date: 2020/12/11 12:18
 * @Description:
 **/
public abstract class Subject {

    //观察者数组
    private Vector<Observer> oVector = new Vector<>();

    //增加一个观察者
    public void addObserver(Observer observer) {
        this.oVector.add(observer);
    }

    //删除一个观察者
    public void deleteObserver(Observer observer) {
        this.oVector.remove(observer);
    }

    //通知所有观察者（这里最好异步处理，避免因某一个观察者出现问题而影响整个进程）
    public void notifyObserver() {
        for (Observer observer : this.oVector) {
            observer.update();
        }
    }

    public abstract void doSomething();
}
