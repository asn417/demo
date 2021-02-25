package com.asn.algoritms.sortAlgorithms;

/**
 * @Author: wangsen
 * @Date: 2020/9/22 11:08
 * @Description: 冒泡排序：稳定
 **/
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {5,1,3,6,2,7,4,6,9};
        bubbleSort(arr);
        for (int i:arr) {
            System.out.println(i);
        }
    }

    public static void bubbleSort(int[] arr){
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]){
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            for (int k:arr) {
                System.out.print(k+" ");
            }
            System.out.println();
        }
    }
}
