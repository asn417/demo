package com.asn.designpattern.observer;

/**
 * @Author: wangsen
 * @Date: 2020/12/11 12:20
 * @Description:
 **/
public class ConcreteSubject extends Subject {

    //具体业务
    @Override
    public void doSomething() {
        //...
        notifyObserver();
    }

}
