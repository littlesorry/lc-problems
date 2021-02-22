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
            if (nums1[i] <= nums2[j]) sort[k] = nums1[i++];
            else sort[k] = nums2[j++];
        }

        if ((total & 1) == 1) {
            return (double) sort[mid - 1];
        } else {
            return ((double) sort[mid - 1] + sort[mid - 2]) / 2;
        }
    }

}
