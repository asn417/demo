package com.example.demo;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Test {
    public static void main(String[] args) throws ParseException {
        B b = (a1,b1) -> a1+b1;
        System.out.println(b.add(1,2));

        String[] arr = {"a","b","c"};

        try{
            System.out.println(new BigDecimal("50%").toString());
        }catch (Exception e){
            System.out.println("1");
        }

        System.out.println("01".equals("1"));
        System.out.println("01".compareTo("1"));
        System.out.println(new BigDecimal("01"));

        Map<String,Object> map = new HashMap<>();
        map.put("str",null);
        String str = (String)null;
        System.out.println(str);
        if (str == null){
            System.out.println("........");
        }
        Arrays.asList(str.split(","));
        System.out.println(str);

        Integer i = new Integer(1);
        String s = new String("1");
        Long l = new Long(1);
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