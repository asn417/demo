package com.asn.designpattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author: wangsen
 * @Date: 2020/9/17 13:11
 * @Description: 动态代理（jdk代理），在Java中要想实现动态代理机制，需要java.lang.reflect.InvocationHandler接口和 java.lang.reflect.Proxy 类的支持。
 *                  代理对象在运行时动态生成。
 *  优点：1）动态代理通过反射机制在运行时决定代理对象，不需要在编译时将委托类和代理类通过接口进行关联，降低耦合度。
 *       2）同时将所有的逻辑都放到invoke方法中统一处理，方便代码维护。
 *  注意：
 *      动态代理对象不需要实现接口，但是要求目标对象必须实现接口，否则不能使用动态代理。
 **/
public class DynamicProxy implements InvocationHandler {

    private Object targetObject;

    public Object newProxyInstance(Object targetObject){
        this.targetObject=targetObject;
        return Proxy.newProxyInstance(targetObject.getClass().getClassLoader(),
                targetObject.getClass().getInterfaces(),this);
    }
    //proxy是被代理的对象，method是调用的具体方法，args是方法中传入的参数
    @Override
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
        System.out.println("invoke-->>");
        for(int i=0;i<args.length;i++){
            System.out.println("参数"+i+"："+args[i]);
        }
        Object ret=null;
        try{
            if (method.getName().contains("get")){
                System.out.println("get前缀方法的统一处理");
            }else {
                System.out.println("非get前缀方法的统一处理");
            }
            //调用目标方法
            ret=method.invoke(targetObject, args);
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("error-->>");
            throw e;
        }
        return ret;
    }
}

