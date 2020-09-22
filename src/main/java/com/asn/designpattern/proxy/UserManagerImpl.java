package com.asn.designpattern.proxy;

/**
 * @Author: wangsen
 * @Date: 2020/9/17 12:55
 * @Description:
 **/
public class UserManagerImpl implements UserManager {
    @Override
    public String getName(String id) {
        System.out.println("getName");
        return "getName方法";
    }

    @Override
    public void setName(String name) {
        System.out.println("setName方法");
    }
}
