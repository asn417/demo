package com.asn.algoritms.sortAlgorithms;

/**
 * @Author: wangsen
 * @Date: 2020/9/22 11:59
 * @Description: 选择排序：不稳定
 **/
public class SelectSort {
    public static void main(String[] args) {
        int[] arr = {5,1,3,6,2,7,4,6,9};
        selectSort(arr);
        for (int i:arr) {
            System.out.println(i);
        }
    }
    public static void selectSort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            int max = arr[0];
            int index = 0;
            for (int j = 0; j < arr.length - i; j++) {
                if (max < arr[j]){
                    max = arr[j];
                    index = j;
                }
            }
            if (arr[arr.length - i - 1] < max){
                arr[index] = arr[arr.length - i - 1];
                arr[arr.length -i - 1] = max;
            }
        }
    }
}
