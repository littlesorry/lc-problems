package com.littlesorry.leetcode.p025;

/**
 * Created by baofeng.wbf on 2016-05-03 5:58 PM.
 */
public class RevertNodesInKGroup {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            this.val = x;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode cur = head;
        int cnt = 0;
        // get next group
        while (cur != null && cnt != k) {
            cur = cur.next;
            cnt++;
        }
        if (cnt == k) {
            cur = reverseKGroup(cur, k);
            // reverse
            while (0 <= --cnt) {
                ListNode tmp = head.next;
                head.next = cur;
                cur = head;
                head = tmp;
            }
            head = cur;
        }
        return head;
    }

    private ListNode reverse(ListNode current) {
        ListNode pre = null;
        ListNode next;

        while (current != null) {
            next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }

        return pre;
    }
}
