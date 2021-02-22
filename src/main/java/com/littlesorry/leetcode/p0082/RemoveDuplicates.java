package com.littlesorry.leetcode.p0082;

import com.littlesorry.leetcode.ListNode;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * <p>
 * User: baofeng.wbf
 * Date: 2018-03-01
 * Time: 下午4:34
 */
public class RemoveDuplicates {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode newHead
                , tail = newHead = new ListNode(-1)
                , current = head;

        newHead.next = null;

        while (current != null) {
            ListNode next = getNext(current);
            if (current.next == null || current.val != current.next.val) {
                tail.next = current;
                tail = current;
                tail.next = null;
            }

            current = next;
        }

        return newHead.next;
    }

    public ListNode getNext(ListNode node) {
        int value = node.val;
        while (node.next != null) {
            if (node.next.val != value) {
                return node.next;
            }

            node = node.next;
        }

        return null;
    }
}
