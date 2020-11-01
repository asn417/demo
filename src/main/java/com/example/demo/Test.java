package com.example.demo;

import com.asn.se.Food;

import java.text.ParseException;

public class Test {
    public static void main(String[] args) throws ParseException {
        Food blackCoffee = Food.Coffee.BLACK_COFFEE;
        System.out.println(blackCoffee);
        System.out.println(blackCoffee.toString());
        System.out.println(Food.Coffee.BLACK_COFFEE.name());
        blackCoffee = Food.Dessert.FRUIT;
        System.out.println(blackCoffee);
        System.out.println(blackCoffee.toString());
    }

    class A extends Test {

    }

}
class A{
    String name;
    final String address;
    static int age;
    public A(String name,String address){
        this.address = address;
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
interface B{
    int add(int a,int b);
}