package com.littlesorry.leetcode.p0206;

import com.littlesorry.leetcode.ListNode;

public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        ListNode current = head, next = null, previous = null;
        while (current != null) {
            next = current.next;
            current.next = previous;

            previous = current;
            current = next;
        }

        return previous;
    }
}
