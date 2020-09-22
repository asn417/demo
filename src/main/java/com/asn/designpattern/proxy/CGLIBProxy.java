package com.asn.designpattern.proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Author: wangsen
 * @Date: 2020/9/17 14:18
 * @Description: cglib代理
 * 优点：
 *      被代理对象无需实现接口，解决jdk代理在这方面的缺陷
 * 缺点：
 *      CGLIB是针对类实现代理，主要是对指定的类生成一个子类，覆盖其中的方法 。 因为是继承，所以该类或方法最好不要声明成final ，final可以阻止继承和多态。
 **/
public class CGLIBProxy implements MethodInterceptor {

    private Object target;//维护一个目标对象
    public CGLIBProxy(Object target) {
        this.target = target;
    }
    //为目标对象生成代理对象
    public Object getProxyInstance() {
        //工具类
        Enhancer en = new Enhancer();
        //设置父类
        en.setSuperclass(target.getClass());
        //设置回调函数
        en.setCallback(this);
        //创建子类对象代理
        return en.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("开启事务");
        // 执行目标对象的方法
        Object returnValue = method.invoke(target, objects);
        System.out.println("关闭事务");
        return null;
    }
}
