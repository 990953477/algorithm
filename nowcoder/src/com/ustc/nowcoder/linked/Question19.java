package com.ustc.nowcoder.linked;

import com.ustc.nowcoder.ListNode;

import java.util.HashMap;

/**
 * 链表中环的入口结点
 * 步骤：采用快慢指针，如果存在环，则一定会碰面。
 *
 * @author tangfeng
 * @since 2019年08月30日 21:21
 */
public class Question19 {

    public HashMap<ListNode, Integer> map = new HashMap<>();

    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null || pHead.next == null)
            return null;

        ListNode pHead1 = pHead;//慢
        ListNode pHead2 = pHead;//快

        while (pHead2 != null || pHead2.next != null){
            pHead1 = pHead1.next;
            pHead2 = pHead2.next.next;
            //发生碰撞，证明有环
            if (pHead1.equals(pHead2)){
                pHead2 = pHead;
                while (!pHead1.equals(pHead2)){
                    pHead1 = pHead1.next;
                    pHead2 = pHead2.next;
                }
                return pHead2;
            }
        }
        return null;
    }

    public static void main(String[] args) {
    }
}
