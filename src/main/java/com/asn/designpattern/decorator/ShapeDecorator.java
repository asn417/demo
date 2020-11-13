package com.asn.designpattern.decorator;

/**
 * @Author: wangsen
 * @Date: 2020/11/12 21:14
 * @Description:
 **/
public abstract class ShapeDecorator implements Shape {
    protected Shape decoratedShape;

    public ShapeDecorator(Shape decoratedShape) {
        this.decoratedShape = decoratedShape;
    }

    public void draw() {
        decoratedShape.draw();
    }
}
