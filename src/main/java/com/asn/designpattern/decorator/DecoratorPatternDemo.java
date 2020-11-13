package com.asn.designpattern.decorator;

/**
 * @Author: wangsen
 * @Date: 2020/11/12 21:14
 * @Description: 装饰器模式：结构型模式，是继承的另一种实现方式，能够在不改变原有类结构的情况下对其进行包装扩展
 **/
public class DecoratorPatternDemo {
    public static void main(String[] args) {

        Shape circle = new Circle();
        ShapeDecorator redCircle = new RedShapeDecorator(new Circle());
        ShapeDecorator redRectangle = new RedShapeDecorator(new Rectangle());
        //Shape redCircle = new RedShapeDecorator(new Circle());
        //Shape redRectangle = new RedShapeDecorator(new Rectangle());
        System.out.println("Circle with normal border");
        circle.draw();

        System.out.println("\nCircle of red border");
        redCircle.draw();

        System.out.println("\nRectangle of red border");
        redRectangle.draw();
    }
}
