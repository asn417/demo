package com.example.demo;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) throws ParseException {
        List<String> list = new ArrayList<>();
        list.add("asd");
        list.add("ss");
        list.add("dd");
        list.add("bb");

        List<String> collect = list.stream().sorted((a, b) -> {
            return a.compareTo(b);
        }).collect(Collectors.toList());


        for (String i :
                list) {
            System.out.print(i);
        }
        System.out.println();
        for (String i :
                collect) {
            System.out.print(i);
        }
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