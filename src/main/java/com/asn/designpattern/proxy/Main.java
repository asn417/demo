package com.asn.designpattern.proxy;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @Author: wangsen
 * @Date: 2020/9/17 13:00
 * @Description:
 **/
public class Main {
    public static void main(String[] args) {
        //静态代理
        StaticProxy staticProxy = new StaticProxy(new UserManagerImpl());
        staticProxy.setName("a");
        staticProxy.getName("1");

        //动态代理
        DynamicProxy dynamicProxy = new DynamicProxy();
        UserManager userManager = (UserManager)dynamicProxy.newProxyInstance(new UserManagerImpl());
        userManager.getName("1");
        userManager.setName("b");

        //cglib代理
        User user = (User) new CGLIBProxy(new User()).getProxyInstance();
        user.getName();

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate d = LocalDate.now();
        String today = d.format(dtf);
        String twentyYearsAgo = d.minusYears(20).format(dtf);

        System.out.println("today:"+today);
        System.out.println("twentyYearsAgo:"+twentyYearsAgo);
        System.out.println(d.getYear());
        System.out.println(d.getDayOfYear());
        System.out.println(d.getDayOfMonth());
        System.out.println(d.getDayOfWeek());

    }

}
