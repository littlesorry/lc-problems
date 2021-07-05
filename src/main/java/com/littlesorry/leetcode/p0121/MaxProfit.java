package com.littlesorry.leetcode.p0121;

public class MaxProfit {

    /**
     * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int max = 0, minPrice = prices[0];
        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            }

            int delta = price - minPrice;
            if (delta > max) {
                max = delta;
            }
        }

        return max;
    }
}
