package com.asn.leetcode.huawei.simple;

/**
 * @Author: wangsen
 * @Date: 2021/1/26 18:11
 * @Description: 统计每个月的兔子数
 * 有一只兔子，从出生后第3个月起每个月都生一只兔子，小兔子长到第三个月后每个月又生一只兔子，假如兔子都不死，问每个月的兔子总数为多少？
 * <p>
 * 本题有多组数据。
 * <p>
 * 输入描述:
 * 输入int型表示month
 * <p>
 * 输出描述:
 * 输出兔子总数int型
 *
 * 示例：
 * 输入：3，输出：2
 * 输入：4:，输出：3
 * 输入：5，输出：5
 **/
public class HJ37 {
    public static void main(String[] args) {
        System.out.println(getNum(5));
        System.out.println(getNum(5));
    }

    public static int getNum(int month) {
        assert (month >= 1);
        if (month == 1 || month == 2)
            return 1;
        return getNum(month - 1) + getNum(month - 2);
    }

    public static int getNum2(int month) {
        assert (month >= 1);
        int first = 1;
        int second = 1;
        int month_count = 1;//当前月兔子数
        while (month > 2) {
            month_count = first + second;
            first = second;
            second = month_count;
            month--;
        }
        return month_count;
    }

}
