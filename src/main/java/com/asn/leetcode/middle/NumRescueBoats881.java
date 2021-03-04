package com.asn.leetcode.middle;

import java.util.Arrays;

/**
 * @Author: wangsen
 * @Date: 2021/3/4 14:00
 * @Description: 救生艇
 * 第 i 个人的体重为 people[i]，每艘船可以承载的最大重量为 limit。
 * 每艘船最多可同时载两人，但条件是这些人的重量之和最多为 limit。
 * 返回载到每一个人所需的最小船数。(保证每个人都能被船载)。
 **/
public class NumRescueBoats881 {
    public static void main(String[] args) {

    }

    public int numRescueBoats(int[] people, int limit) {
        int result = 0;
        Arrays.sort(people);
        int left = 0, right = people.length - 1;
        while (left <= right) {
            if (left == right) {
                result++;
                break;
            }
            if (people[right] + people[left] > limit) {
                right--;
                result++;
            } else {
                right--;
                left++;
                result++;
            }
        }
        return result;
    }
}
