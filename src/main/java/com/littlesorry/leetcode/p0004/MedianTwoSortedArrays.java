package com.littlesorry.leetcode.p0004;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * <p>
 * User: baofeng.wbf
 * Date: 2018-08-30
 * Time: 下午4:39
 */
public class MedianTwoSortedArrays {

    // FIXME
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int total = nums1.length + nums2.length;
        int mid = total >> 1;

        int[] sort = new int[mid];
        int i = 0, j = 0;
        for (int k = 0; k <= mid; k++) {
            if (nums1[i] <= nums2[j]) sort[k] = nums1[min(i++, nums2.length -1)];
            else sort[k] = nums2[min(j++, nums2.length -1)];
        }

        if ((total & 1) == 1) {
            return (double) sort[mid - 1];
        } else {
            return ((double) sort[mid - 1] + sort[mid - 2]) / 2;
        }
    }

    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int i = 0, j = 0, step = 0, result = 0, current = 0
                , centerLeft = (nums1.length + nums2.length - 1) / 2
                , centerRight = (nums1.length + nums2.length) / 2;

        for (;;) {
            int val1 = i < nums1.length ? nums1[i] : Integer.MAX_VALUE;
            int val2 = j < nums2.length ? nums2[j] : Integer.MAX_VALUE;

            if (step == centerLeft) {
                result += min(val1, val2);
            }
            if (step == centerRight) {
                result += min(val1, val2);
                break;
            }

            current = val1 < val2 ? i++ : j++;
            step++;
        }

        return ((double) result) / 2;
    }

    private static int min(int a, int b) {
        return a < b ? a : b;
    }

}
