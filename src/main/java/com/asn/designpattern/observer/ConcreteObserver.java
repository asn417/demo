package com.asn.designpattern.observer;

/**
 * @Author: wangsen
 * @Date: 2020/12/11 12:20
 * @Description:
 **/
public class ConcreteObserver implements Observer {

    @Override
    public void update() {
        System.out.println(this.getClass().getName() + "收到消息，进行处理");
    }

}
