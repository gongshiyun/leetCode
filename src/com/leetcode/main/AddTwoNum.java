package com.leetcode.main;

import com.leetcode.entity.ListNode;

/**
 * LeetCode 2 You are given two non-empty linked lists representing two
 * non-negative integers. The digits are stored in reverse order and each of
 * their nodes contain a single digit. Add the two numbers and return it as a
 * linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the
 * number 0 itself.
 *
 * Example
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 7 -> 0 -> 8 Explanation: 342 +
 * 465 = 807.
 *
 * @author gongshiyun
 * @date: 2018/5/3 0:35
 */
public class AddTwoNum {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(5);
        ListNode l5 = new ListNode(6);
        ListNode l6 = new ListNode(4);

        l1.setNext(l2);
        l2.setNext(l3);
        l4.setNext(l5);
        l5.setNext(l6);

        //System.out.println(addTwoNumbers(l1,l4));
        ListNode result = addTwoNumbers(l1, l4);
        System.out.print(result.getVal());
        while (result.getNext() != null) {
            System.out.print(" -> ");
            result = result.getNext();
            System.out.print(result.getVal());
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int val1 = 0;
        int val2 = 0;
        int val3 = 0;
        int sum = 0;
        //int result = 0;
        //int count = 0;
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode head = new ListNode(0);
        ListNode pListNode = head;

        while (p1 != null || p2 != null || val3 == 1) {
            val1 = 0;
            val2 = 0;
            if (p1 != null) {
                val1 = p1.getVal();
                p1 = p1.getNext();
            }
            if (p2 != null) {
                val2 = p2.getVal();
                p2 = p2.getNext();
            }
            sum = val1 + val2 + val3;
            val3 = sum >= 10 ? 1 : 0;
            sum = sum % 10;
            ListNode temp = new ListNode(sum);
            pListNode.setNext(temp);
            pListNode = temp;
            //result += sum * Math.pow(10, count);

            //++count;
        }

        return head.getNext();
    }
}
