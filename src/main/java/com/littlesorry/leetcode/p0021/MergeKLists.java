package com.littlesorry.leetcode.p0021;

import com.littlesorry.leetcode.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKLists {

    /**
     * better solution
     *
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        for (ListNode node : lists) {
            if (node != null) priorityQueue.offer(node);
        }

        ListNode result = new ListNode(), currentResultNode = result;
        while (!priorityQueue.isEmpty()) {
            ListNode current = priorityQueue.poll();
            currentResultNode.next = current;
            currentResultNode = currentResultNode.next;

            if (current.next != null) priorityQueue.offer(current.next);
        }

        return result.next;
    }

    private InsertNode insert(InsertNode insertList, ListNode node) {
        if (insertList == null) {
            return new InsertNode(node);
        }

        InsertNode previous = null, newInsert = new InsertNode(node);
        for (InsertNode insert = insertList; insert != null; insert = insert.next) {
            if (node.val <= insert.val) {
                newInsert.next = insert;
                if (previous == null) {
                    return newInsert;
                }

                previous.next = newInsert;
                return insertList;
            }

            previous = insert;
        }

        previous.next = newInsert;
        return insertList;
    }

    private class InsertNode {

        private ListNode node;

        private InsertNode next = null;

        private int val;

        public InsertNode(ListNode node) {
            this.node = node;
            this.val = node.val;
        }
    }


    /**
     * slow implementation
     *
     * @param lists
     * @return
     */
    public ListNode mergeKListsSlow(ListNode[] lists) {

        ListNode newHead = null, previous = null, current = null;
        do {
            current = pickMin(lists);
            newHead = newHead == null ? current : newHead;
            if (previous != null) {
                previous.next = current;
            }

            previous = current;
        } while (current != null);

        return newHead;
    }

    private ListNode pickMin(ListNode[] lists) {
        int minIdx = -1;
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                if (minIdx == -1 || lists[i].val < lists[minIdx].val) {
                    minIdx = i;
                }
            }
        }

        if (minIdx == -1) {
            return null;
        }

        ListNode min = lists[minIdx];
        lists[minIdx] = lists[minIdx].next;
        return min;
    }
}
