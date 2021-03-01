package com.asn.leetcode.simple;

import java.util.Stack;

/**
 * 有效的括号
 */
public class IsValid20 {
    public static void main(String[] args) {

    }
    public static boolean isValid(String s) {
        if (s.length()<2)
            return false;
        Stack<Character> stack = new Stack<>();
        char[] arr = s.toCharArray();
        for (char c : arr) {
            if (stack.isEmpty() && (c==')' || c==']' || c=='}')) {
                return false;
            } else if (c=='(' || c=='[' || c=='{'){
                stack.add(c);
            }else if (c==')' && stack.pop() != '('){
                return false;
            }else if (c==']' && stack.pop() != '['){
                return false;
            }else if (c=='}' && stack.pop() != '{'){
                return false;
            }
        }
        return stack.isEmpty();
    }
}
