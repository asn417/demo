package com.asn.designpattern.proxy;

/**
 * @Author: wangsen
 * @Date: 2020/9/17 12:51
 * @Description: 静态代理模式：代理对象在编译期生成
 *
 * 优点：代理对象通过实现与委托对象相同的接口来确保动作上的一致性，同时可以代理所有实现了相同接口的委托对象。
 *       此外，委托对象可以通过工厂模式实现，这样能在客户端隐藏具体的委托对象。
 * 缺点：1）代理类和委托类实现了相同的接口，当接口新增加方法时，需要同时修改代理类和委托类，代码维护难度大，不易扩展。
 *      2）代理类和委托类通过实现相同的接口相关联，当有大量的不同类都需要代理时，需要为各个类维护对应的接口和代理类，代码量变大。
 **/
public class StaticProxy implements UserManager{
    private UserManager userManager;
    public StaticProxy(UserManager userManager){
        this.userManager = userManager;
    }

    @Override
    public String getName(String id) {
        System.out.println("代理对象在委托对象调用getName()方法前的额外功能");
        userManager.getName(id);
        return null;
    }

    @Override
    public void setName(String name) {
        System.out.println("代理对象在委托对象调用setName()方法前的额外功能");
        userManager.setName(name);
    }
}
