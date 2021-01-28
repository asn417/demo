package com.asn.designpattern.strategy;

/**
 * 策略模式：主要有三个角色，策略接口（或抽象类）、具体的策略实现类、策略工厂（通过工厂控制调用哪个策略实现）
 **/
public class Client {

    public static void main(String[] args) {
        Context context;

        context = new Context(new ConcreteStrategyA());
        context.contextInterface();

        context = new Context(new ConcreteStrategyB());
        context.contextInterface();

        context = new Context(new ConcreteStrategyC());
        context.contextInterface();
    }

}