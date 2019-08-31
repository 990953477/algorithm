package com.ustc.nowcoder.linked;

import com.ustc.nowcoder.ListNode;

/**
 * 删除重复节点
 *
 * @author tangfeng
 * @since 2019年08月30日 21:52
 */
public class Question20 {
    public static void main(String[] args) {

    }

    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null)
            return pHead;

        //虚头结点- 防止第一个和第二个节点相同
        ListNode phonHead = new ListNode(0);
        phonHead.next = pHead;
        //指向确定不重复的那个节点
        ListNode pre = phonHead;
        //工作指针，一直向后扫描
        ListNode last = phonHead.next;
        while (last != null) {
            if (last.next != null && last.val == last.next.val) {
                //找到最后一个相同的节点
                while (last.next != null && last.val == last.next.val) {
                    last = last.next;
                }
                pre.next = last.next;
                last = last.next;
            } else {
                pre = pre.next;
                last = last.next;
            }
        }
        return phonHead.next;
    }
}

