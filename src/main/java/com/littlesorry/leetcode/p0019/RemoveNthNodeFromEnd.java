package com.littlesorry.leetcode.p0019;

import com.littlesorry.leetcode.ListNode;

public class RemoveNthNodeFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode ahead = head, nth = head, nthPrev = null;
        for (int i = 0; i < n - 1; i++) {
            ahead = ahead.next;
        }

        while (ahead != null && ahead.next != null) {
            ahead = ahead.next;
            nthPrev = nth;
            nth = nth.next;
        }

        if (nth == head) {
            return nth.next;
        }

        nthPrev.next = nth.next;
        return head;
    }
}
