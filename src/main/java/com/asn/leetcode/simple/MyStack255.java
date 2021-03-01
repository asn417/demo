package com.asn.leetcode.simple;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 用队列实现栈
 */
class MyStack255 {
    public static void main(String[] args) {
        MyStack255 stack = new MyStack255();
        stack.push(1);
        stack.push(2);
        System.out.println(stack.top());
        System.out.println(stack.pop());
        System.out.println(stack.top());
        System.out.println(stack.empty());
    }


    Queue<Integer> q1,q2;
    /** Initialize your data structure here. */
    public MyStack255() {
        q1 = new LinkedList();
        q2 = new LinkedList();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        q2.clear();
        q2.add(x);
        while (!empty()){
            q2.add(q1.poll());
        }
        q1 = q2;
        q2 = new LinkedList<>();
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return q1.poll();
    }
    
    /** Get the top element. */
    public int top() {
        return q1.peek();
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q1.size() == 0;
    }
}