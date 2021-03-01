package com.asn.leetcode.simple;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class RecentCounter933 {
    Queue<Integer> queue;
    public RecentCounter933() {
        queue = new LinkedList<Integer>();
    }
    
    public int ping(int t) {
        queue.add(t);
        while (queue.peek()<t-3000){
            queue.poll();
        }
        return queue.size();
    }
}