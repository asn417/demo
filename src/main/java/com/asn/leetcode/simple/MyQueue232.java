package com.asn.leetcode.simple;

import java.util.Stack;

/**
 * 用栈实现队列
 **/
class MyQueue232 {
    Stack<Integer> stack;
    Stack<Integer> stack1;

    /**
     * Initialize your data structure here.
     */
    public MyQueue232() {
        stack = new Stack<>();
        stack1 = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        while (!stack.isEmpty()) {
            stack1.push(stack.pop());
        }
        stack.push(x);
        while (!stack1.isEmpty()) {
            stack.push(stack1.pop());
        }
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        return stack.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        return stack.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return stack.isEmpty();
    }
}