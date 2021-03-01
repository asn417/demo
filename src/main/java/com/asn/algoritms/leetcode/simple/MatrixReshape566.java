package com.asn.algoritms.leetcode.simple;

/**
 * 重塑矩阵
 */
public class MatrixReshape566 {
    public static void main(String[] args) {
        int[][] nums = {{1,2},{3,4}};
        matrixReshape(nums,2,4);
    }

    public static int[][] matrixReshape(int[][] nums, int r, int c) {
        int row = nums.length;
        int col = nums[0].length;

        if (row*col!=r*c)
            return nums;

        int tempR = 0,tempC = 0,count = 0;
        int[][] res = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (count==row*col)
                    return res;
                if (tempC<col){
                    res[i][j] = nums[tempR][tempC++];
                    count++;
                }else {
                    tempC=0;
                    res[i][j] = nums[++tempR][tempC++];
                    count++;
                }
            }
        }
        return res;
    }
}
