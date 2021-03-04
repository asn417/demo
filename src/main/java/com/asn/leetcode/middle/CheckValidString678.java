package com.asn.leetcode.middle;

import java.util.Stack;

/**
 * 有效的括号字符串
 */
public class CheckValidString678 {
    public static void main(String[] args) {
        String s = "((((()(()()()*()(((((*)()*(**(())))))(())()())(((())())())))))))(((((())*)))()))(()((*()*(*)))(*)()";
        System.out.println(checkValidString(s));
    }

    //双栈
    public static boolean checkValidString(String s) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            if (c == '(') {
                stack1.push(i);
            } else if (c == '*') {
                stack2.push(i);
            } else {
                if (!stack1.isEmpty()) {
                    stack1.pop();
                } else if (!stack2.isEmpty()) {
                    stack2.pop();
                } else {
                    return false;
                }
            }
        }
        if (stack1.size() > stack2.size()) {
            return false;
        }
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            if (stack1.pop() > stack2.pop()) {
                return false;
            }
        }
        return true;
    }
}
