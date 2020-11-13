package com.asn.designpattern.decorator;

/**
 * @Author: wangsen
 * @Date: 2020/11/12 21:14
 * @Description:
 **/
public class Circle implements Shape {

    @Override
    public void draw() {
        System.out.println("Shape: Circle");
    }
}
