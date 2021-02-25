package com.asn.leetcode.middle;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: wangsen
 * @Date: 2021/2/25 16:38
 * @Description: 括号生成
 **/
public class GenerateParenthesis22 {
    static List<String> res = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }

    public static List<String> generateParenthesis(int n) {
        dfs(n, n, "");
        return res;
    }

    private static void dfs(int left, int right, String curStr) {
        if (left == 0 && right == 0) { // 左右括号都不剩余了，递归终止
            res.add(curStr);
            return;
        }
        if (left > 0) { // 如果左括号还剩余的话，可以拼接左括号
            dfs(left - 1, right, curStr + "(");
        }
        if (right > left) { // 如果右括号剩余多于左括号剩余的话，可以拼接右括号
            dfs(left, right - 1, curStr + ")");
        }
    }
}
