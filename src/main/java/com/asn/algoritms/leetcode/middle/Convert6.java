package com.asn.algoritms.leetcode.middle;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: wangsen
 * @Date: 2021/2/4 13:05
 * @Description: Z字型变换
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 * 请你实现这个将字符串进行指定行数变换的函数：
 * string convert(string s, int numRows);
 *  
 * 示例 1：
 * <p>
 * 输入：s = "PAYPALISHIRING", numRows = 3
 * 输出："PAHNAPLSIIGYIR"
 * 示例 2：
 * 输入：s = "PAYPALISHIRING", numRows = 4
 * 输出："PINALSIGYAHRPI"
 * 解释：
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 * 示例 3：
 * <p>
 * 输入：s = "A", numRows = 1
 * 输出："A"
 *  
 * 提示：
 * 1 <= s.length <= 1000
 * s 由英文字母（小写和大写）、',' 和 '.' 组成
 * 1 <= numRows <= 1000
 **/
public class Convert6 {
    public static void main(String[] args) {
        System.out.println(convert("AB", 1));
    }

    public static String convert(String s, int numRows) {
        //只有一行时直接输出
        if (numRows == 1)
            return s;
        StringBuilder res = new StringBuilder();
        int up = numRows - 1, down = 0;
        boolean flag = true;//flag标识控制上下遍历关系
        ArrayList<String>[] arr = new ArrayList[numRows];
        for (int i = 0; i < s.length(); i++) {
            String str = s.substring(i, i + 1);
            if (i < numRows) {
                ArrayList<String> list = new ArrayList<>();
                list.add(str);
                arr[i] = list;
            } else if (flag) {
                arr[--up].add(str);
                if (up == 0) {
                    flag = false;
                    down = 0;
                }
            } else {
                arr[++down].add(str);
                if (down == numRows - 1) {
                    up = numRows - 1;
                    flag = true;
                }
            }
        }
        for (ArrayList<String> list : arr) {
            //过滤掉空行
            if (list != null) {
                list.stream().forEach(str -> {
                    res.append(str);
                });
            }
        }
        return res.toString();
    }

    /**
     * 官方解法一：(其实思路一致，只是没有官方答案优雅)
     * 思路:
     * 通过从左向右迭代字符串，我们可以轻松地确定字符位于 Z 字形图案中的哪一行。
     * 算法:
     * 我们可以使用 min(numRows,len(s)) 个列表来表示 Z 字形图案中的非空行。
     * 从左到右迭代 s，将每个字符添加到合适的行。可以使用当前行和当前方向这两个变量对合适的行进行跟踪。
     * 只有当我们向上移动到最上面的行或向下移动到最下面的行时，当前方向才会发生改变。
     **/
    public String convert1(String s, int numRows) {
        if (numRows == 1) return s;
        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++)
            rows.add(new StringBuilder());
        int curRow = 0;
        boolean goingDown = false;
        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            //优雅
            if (curRow == 0 || curRow == numRows - 1) goingDown = !goingDown;
            curRow += goingDown ? 1 : -1;
        }
        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : rows) ret.append(row);
        return ret.toString();
    }
}
