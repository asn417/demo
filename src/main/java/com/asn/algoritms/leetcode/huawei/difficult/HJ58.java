package com.asn.algoritms.leetcode.huawei.difficult;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * 输入n个数，求最小的k个数，从小到大返回数组
 * 可以使用Arrays.sort()，或Collections.sort();
 * 这题并不难，只是输入的数据和输出的数据要控制好。先输入n，再输入k，最后再输入n个数。
 */
public class HJ58 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int num = sc.nextInt();
            int k = sc.nextInt();
            ArrayList al = new ArrayList();
            for(int i = 0;i<num;i++){
                al.add(sc.nextInt());
            }
            Collections.sort(al);
            for(int j = 0;j<k;j++){
                if(j == k-1){
                    System.out.println(al.get(j));
                }else{
                    System.out.print(al.get(j)+" ");
                }
            }
        }
    }
}
