package com.asn.designpattern.decorator;

/**
 * @Author: wangsen
 * @Date: 2020/11/12 21:13
 * @Description:
 **/
public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Shape: Rectangle");
    }
}
