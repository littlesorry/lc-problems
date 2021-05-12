package com.littlesorry.leetcode.p0347;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class TopKFrequentElem {

    public static void main(String[] args) {
        int[] input = new int[]{3,2,3,1,2,4,5,5,6,7,7,8,2,3,1,1,1,10,11,5,6,2,4,7,8,5,6};

        System.out.println(new TopKFrequentElem().topKFrequent(input, 10));
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, AtomicInteger> counters = new HashMap<>();
        for (int num : nums) {
            counters.computeIfAbsent(num, n -> new AtomicInteger(0)).addAndGet(1);
        }

        Queue<Integer> topK = new PriorityQueue<>((o1, o2) -> counters.get(o1).get() - counters.get(o2).get());
        for (Map.Entry<Integer, AtomicInteger> integerAtomicIntegerEntry : counters.entrySet()) {
            topK.add(integerAtomicIntegerEntry.getKey());
            if (topK.size() > k) {
                topK.poll();
            }
        }

        return topK.stream().mapToInt(value -> value).toArray();
    }
}
