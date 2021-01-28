package com.asn.designpattern.strategy;

/**
 * @Author: wangsen
 * @Date: 2021/1/28 15:46
 * @Description:
 **/
public class Context {

    Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    //上下文接口
    public void contextInterface() {
        strategy.algorithmInterface();
    }
}
