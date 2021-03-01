package com.asn.leetcode.simple;

/**
 * @Author: wangsen
 * @Date: 2021/2/25 11:11
 * @Description: 转置矩阵，也就是二维数组中每个元素的横纵坐标互换
 **/
public class Transpose867 {
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3}, {4, 5, 6}};
        int[][] transArr = transpose(arr);
        for (int i = 0; i < transArr.length; i++) {
            for (int j = 0; j < transArr[0].length; j++) {
                System.out.print(transArr[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static int[][] transpose(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] res = new int[col][row];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                res[j][i] = matrix[i][j];
            }
        }
        return res;
    }
}
