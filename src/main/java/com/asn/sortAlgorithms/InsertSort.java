package com.asn.sortAlgorithms;

/**
 * @Author: wangsen
 * @Date: 2020/9/22 12:11
 * @Description: 插入排序：稳定
 **/
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {5,1,3,6,2,7,4,6,9};
        insertSort(arr);
        for (int i:arr) {
            System.out.println(i);
        }
    }
    public static void insertSort(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] >= arr[j - 1]){
                    break;
                }else {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
        }
    }
}
