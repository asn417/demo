package com.asn.algoritms.leetcode.middle;

import java.util.*;

/**
 * 三数之和
 * 本题的关键是去除重复的三元组。可以通过“排序+哈希表”解决。
 */
public class ThreeSum15 {
    public static void main(String[] args) {

    }
    //暴力解法：三重循环，超时
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        Set<String> set = new HashSet<>();
        for (int i = 0; i < nums.length-2; i++) {
            int a = nums[i];
            for (int j = i+1; j < nums.length-1; j++) {
                int b = nums[j];
                for (int k = j+1; k < nums.length; k++) {
                    int sum=nums[i]+nums[j]+nums[k];
                    if (sum==0 && !set.contains(""+a+b+nums[k])){
                        List<Integer> list = new ArrayList<>();
                        list.add(a);
                        list.add(b);
                        list.add(nums[k]);
                        res.add(list);
                        set.add(""+a+b+nums[k]);
                    }else if (sum<0){
                        continue;
                    }else {
                        break;
                    }
                }
            }
        }
        return res;
    }

    //暴力解法的优化：双指针+哈希表
    public static List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        Set<String> set = new HashSet<>();
        for (int i = 0; i < nums.length-2; i++) {
            int a = nums[i];
            for (int j=i+1,k=nums.length-1;j<k;){
                int b = nums[j];
                int c = nums[k];
                int sum = a + b + c;
                if (sum==0 && !set.contains(""+a+b+c)){
                    List<Integer> list = new ArrayList<>();
                    list.add(a);
                    list.add(b);
                    list.add(c);
                    res.add(list);
                    set.add(""+a+b+c);
                }else if (sum < 0){
                    j++;
                }else {
                    k--;
                }
            }
        }
        return res;
    }

    //继续优化：
    public static List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        Set<String> set = new HashSet<>();
        for (int i = 0; i < nums.length-2; i++) {
            int a = nums[i];
            if (i==0 || a!=nums[i-1]) {
                for (int j = i + 1, k = nums.length - 1; j < k; ) {
                    int b = nums[j];
                    int c = nums[k];
                    int sum = a + b + c;
                    if (sum == 0 && !set.contains("" + a + b + c)) {
                        List<Integer> list = new ArrayList<>();
                        list.add(a);
                        list.add(b);
                        list.add(c);
                        res.add(list);
                        set.add("" + a + b + c);
                    } else if (sum < 0) {
                        j++;
                    } else {
                        k--;
                    }
                }
            }
        }
        return res;
    }
}
