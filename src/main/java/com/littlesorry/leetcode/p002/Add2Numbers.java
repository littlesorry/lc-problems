package com.littlesorry.leetcode.p002;

/**
 * Created by baofeng.wbf on 2016-05-03 6:03 PM.
 */
public class Add2Numbers {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return add(l1, l2, false);
    }

    public ListNode add(ListNode l1, ListNode l2, boolean incr) {
        if (l1 == null && l2 == null && !incr) return null;

        int added = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + (incr ? 1 : 0);
        ListNode node = new ListNode(added % 10);
        node.next = add(l1 != null ? l1.next : null, l2 != null ? l2.next : null, added > 9);

        return node;
    }
}
