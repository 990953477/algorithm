package com.ustc.nowcoder.linked;

import com.ustc.nowcoder.ListNode;

/**
 * @author tangfeng
 * @since 2019年08月27日 16:38
 */
public class Question02 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        ListNode node11 = new ListNode(11);
        ListNode node12 = new ListNode(12);
        ListNode node13 = new ListNode(13);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        node11.next = node12;
        node12.next = node13;
        node13.next = null;

        Question02 question02 = new Question02();
        ListNode result = question02.FindFirstCommonNode(node1, node11);
        System.out.println(result.val);
    }

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;

        while (p1 != p2) {
            p1 = (p1 == null ? pHead2 : p1.next);
            p2 = (p2 == null ? pHead1 : p2.next);
        }
        return p1;
    }
}
