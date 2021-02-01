package com.asn.leetcode.slidingwindow;

import java.util.*;

/**
 * @Author: wangsen
 * @Date: 2021/2/1 13:22
 * @Description: 公平的糖果交换
 * 爱丽丝和鲍勃有不同大小的糖果棒：A[i] 是爱丽丝拥有的第 i 根糖果棒的大小，B[j] 是鲍勃拥有的第 j 根糖果棒的大小。
 * 因为他们是朋友，所以他们想交换一根糖果棒，这样交换后，他们都有相同的糖果总量。（一个人拥有的糖果总量是他们拥有的糖果棒大小的总和。）
 * 返回一个整数数组 ans，其中 ans[0] 是爱丽丝必须交换的糖果棒的大小，ans[1] 是 Bob 必须交换的糖果棒的大小。
 * <p>
 * 如果有多个答案，你可以返回其中任何一个。保证答案存在。
 * <p>
 * 示例 1：
 * <p>
 * 输入：A = [1,1], B = [2,2]
 * 输出：[1,2]
 * 示例 2：
 * <p>
 * 输入：A = [1,2], B = [2,3]
 * 输出：[1,2]
 * 示例 3：
 * <p>
 * 输入：A = [2], B = [1,3]
 * 输出：[2,3]
 * 示例 4：
 * <p>
 * 输入：A = [1,2,5], B = [2,4]
 * 输出：[5,4]
 *  
 * 提示：
 * <p>
 * 1 <= A.length <= 10000
 * 1 <= B.length <= 10000
 * 1 <= A[i] <= 100000
 * 1 <= B[i] <= 100000
 * 保证爱丽丝与鲍勃的糖果总量不同。
 * 答案肯定存在。
 **/
public class FairCandySwap888 {
    public static void main(String[] args) {

    }

    //时间复杂度 m*n
    public static int[] fairCandySwap(int[] A, int[] B) {
        int countA = 0, countB = 0;
        for (int i = 0; i < A.length; i++) {
            countA += A[i];
        }
        for (int i = 0; i < B.length; i++) {
            countB += B[i];
        }
        int sub = countA - countB;

        if (sub % 2 != 0)
            return null;

        int[] res = new int[2];
        label:
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                if ((A[i] - B[j]) * 2 == sub) {
                    res[0] = A[i];
                    res[1] = B[j];
                    break label;
                }
            }
        }

        return res;
    }

    //优化：假设A总量为countA,B总量为countB,那么只需要找到一个(A[i]-B[j])*2=countA-countB即可。
    public int[] fairCandySwap1(int[] A, int[] B) {
        int sumA = Arrays.stream(A).sum();
        int sumB = Arrays.stream(B).sum();
        int delta = (sumA - sumB) / 2;
        Set<Integer> rec = new HashSet<Integer>();
        for (int num : A) {
            rec.add(num);
        }
        int[] ans = new int[2];
        for (int y : B) {
            int x = y + delta;
            if (rec.contains(x)) {
                ans[0] = x;
                ans[1] = y;
                break;
            }
        }
        return ans;
    }
}
