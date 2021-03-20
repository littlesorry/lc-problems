package com.littlesorry.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class QuickSort {

    public static void main(String[] args) {

        final Random random = new Random();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            list.add(random.nextInt(100));
        }

        Integer[] integers = list.toArray(new Integer[0]);
        System.out.println(integers);

        new QuickSort().quickSort(integers, 0, integers.length);
        System.out.println(integers);
    }


    public void quickSort(Integer[] array, int left, int right) {
        if (left < right) {
            int pivot = partition(array, left, right);

            quickSort(array, left, pivot - 1);
            quickSort(array, pivot + 1, right);
        }
    }

    public int partition(Integer[] array, int left, int right) {
        int pi = left - 1;
        int pivot = array[right];
        for (int j = left; j < right; j++) {
            if (array[j] <= pivot) {
                pi++;

                int swap = array[pi];
                array[pi] = array[j];
                array[j] = swap;
            }
        }

        int swap = array[pi + 1];
        array[pi + 1] = array[right];
        array[right] = swap;

        return pi + 1;
    }
}
