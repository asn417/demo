package com.asn.algoritms.leetcode.huawei.difficult;

import java.util.Scanner;

public class HJ13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String line = sc.nextLine();
            String[] arr = line.split(" ");
            for (int i = arr.length-1; i >= 0 ; i--) {
                System.out.print(arr[i]+" ");
            }
            System.out.println();
        }
    }
}
