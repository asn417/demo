package com.asn.algoritms.leetcode.huawei.middle;

import java.util.*;

public class Main {
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNextInt())
        {
            System.out.println(count(sc.nextInt(),sc.nextInt()));
        }
        sc.close();
    }
    public static int count(int m,int n)
    {
        if(m<0||n<=0)
            return 0;
        //细分到苹果数为一或盘子数为一的情况返回一
        if(m==1||n==1||m==0)
            return 1;
        //将此事件无线细分
        return count(m,n-1)+count(m-n,n);
    }
}