package com.littlesorry.leetcode.p0080;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * <p>
 * User: baofeng.wbf
 * Date: 2018-03-01
 * Time: 下午3:58
 */
public class RemoveDuplicatesFromSortedArray {


    /**
     *
     * not solved
     *
     * @param nums
     * @return
     */
    public static int removeDuplicates(int[] nums) {
        int groupLength = 1;
        for (int i = 1; i < nums.length; i++) {
            int current = nums[i];
            if (current == nums[i - 1]) {
                groupLength++;
                if (groupLength == 3) {
                    return i - 1;
                }
            } else {

                groupLength = 1;
            }
        }

        return groupLength > 2 ? nums.length - (groupLength - 2) : nums.length;
    }

//    public static int removeDuplicates(int[] nums) {
//        if (nums.length == 0) {
//            return 0;
//        }
//
//        int length = 0, groupLength = 1;
//        for (int i = 1; i < nums.length; i++) {
//            int current = nums[i];
//            if (current == nums[i - 1]) {
//                groupLength++;
//            } else {
//                length += groupLength > 2 ? 2 : groupLength;
//                groupLength = 1;
//            }
//        }
//
//        length += groupLength > 2 ? 2 : groupLength;
//
//        return length;
//    }


    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{}));
        System.out.println(removeDuplicates(new int[]{1, 1, 2, 2, 2, 3}));
        System.out.println(removeDuplicates(new int[]{1, 1, 2, 2, 3, 3}));
    }
}
