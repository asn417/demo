package com.asn.leetcode.simple;

import com.asn.leetcode.ListNode;

import java.util.Stack;

/**
 * @Author: wangsen
 * @Date: 2021/3/1 13:35
 * @Description: 反转链表
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * <p>
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 **/
public class ReverseList206 {
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
        //ListNode node = help2(node1);
        ListNode resHead = new ListNode(0);
        ListNode node = help2(node1, resHead);
        node.next = null;
        while (resHead != null) {
            System.out.print(resHead.val + " ");
            resHead = resHead.next;
        }
    }


    //方法一：迭代
    public static ListNode reverseList1(ListNode head) {
        ListNode res = new ListNode(0);
        ListNode next, temp = head;
        while (temp != null) {
            next = temp.next;
            temp.next = res.next;
            res.next = temp;
            temp = next;
        }
        return res.next;
    }

    //方法二：递归
    public static ListNode reverseList2(ListNode head) {
        ListNode resHead = new ListNode(0);
        ListNode node = help2(head, resHead);
        node.next = null;
        return resHead.next;
    }

    public static ListNode help2(ListNode head, ListNode resHead) {
        if (head == null) {
            return resHead;
        } else {
            ListNode node = help2(head.next, resHead);
            node.next = head;
            return head;
        }
    }

    //方法三：利用栈
    public static ListNode reverseList3(ListNode head) {
        ListNode res = new ListNode(0);
        ListNode resTemp = res, temp = head;
        Stack<ListNode> stack = new Stack<>();
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }
        while (!stack.empty()) {
            resTemp.next = stack.pop();
            resTemp = resTemp.next;
        }
        resTemp.next = null;
        return res.next;
    }
}
