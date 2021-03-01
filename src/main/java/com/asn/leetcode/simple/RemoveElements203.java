package com.asn.leetcode.simple;

import com.asn.leetcode.ListNode;

/**
 * @Author: wangsen
 * @Date: 2021/3/1 11:56
 * @Description: 移除链表中等于给定值val的所有元素
 **/
public class RemoveElements203 {
    public static void main(String[] args) {

    }

    public ListNode removeElements(ListNode head, int val) {
        //空链表直接返回null
        if (head == null) {
            return null;
        }
        //遍历链表，找到第一个值不为val的节点作为head
        while (head.val == val) {
            head = head.next;
            if (head == null)
                return null;
        }
        //定义前后两个阶段pre和next
        ListNode pre = head, next = pre.next;
        while (next != null) {
            if (next.val == val) {
                next = next.next;
            } else {
                pre.next = next;
                pre = next;
                next = next.next;
            }
        }
        pre.next = null;
        return head;
    }
}
