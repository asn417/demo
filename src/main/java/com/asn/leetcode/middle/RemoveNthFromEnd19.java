package com.asn.leetcode.middle;


/**
 * @Author: wangsen
 * @Date: 2021/2/25 11:51
 * @Description: 删除链表的倒数第N个节点
 * 倒数第N个，那么可以使用两个指针，前一个比后一个多走N步，当前一个到达末尾时，后一个所在位置即为倒数第N个节点
 **/
public class RemoveNthFromEnd19 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode res = removeNthFromEnd(node1, 5);
        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
        System.out.println();
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = head, last = head;

        for (int i = 0; i < n; i++) {
            pre = pre.next;
        }
        if (pre == null) {
            return head.next;
        }
        while (pre.next != null) {
            pre = pre.next;
            last = last.next;
        }
        last.next = last.next.next;
        return head;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}