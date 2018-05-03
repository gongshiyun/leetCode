package com.leetcode.main;

import com.leetcode.entity.ListNode;

import java.util.List;

/**
 * 19
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 *
 * 说明：
 *
 * 给定的 n 保证是有效的。
 *
 * 进阶：
 *
 * 你能尝试使用一趟扫描实现吗？
 *
 * @author gongshiyun
 * @date: 2018/5/3 22:21
 */
public class RemoveNthFromEnd {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(4);
        //ListNode l3 = new ListNode(3);
        //ListNode l4 = new ListNode(5);
        //ListNode l5 = new ListNode(6);

        l1.setNext(l2);
        //l2.setNext(l3);
        //l3.setNext(l4);
        //l4.setNext(l5);
        ListNode result = removeNthFromEnd(l1,1);
        System.out.print(result.val);
        while (result.next != null) {
            System.out.print(" -> ");
            result = result.next;
            System.out.print(result.val);
        }
    }

    /**
     * 思想:使用快慢指针,一个快n步遍历,当快指针到达末尾,慢指针指向要删除的节点
     * head->a->b->c->d
     * @param head
     * @param n
     * @return
     */
    private static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode headNode = new ListNode(0);
        headNode.next = head;
        ListNode fastNode = headNode;
        ListNode slowNode = headNode;
        while (fastNode.next != null){
            fastNode = fastNode.next;
            if (n-- <= 0){
                slowNode = slowNode.next;
            }
        }

        if (slowNode.next != null){
            slowNode.next = slowNode.next.next;
        }

        return headNode.next;
    }
}
