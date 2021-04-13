package com.littlesorry.leetcode.p0064;

public class MinimumPathSum {

    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        int[][] sums = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    sums[i][j] = grid[i][j];
                } else if (i == 0) {
                    sums[i][j] = sums[i][j - 1] + grid[i][j];
                } else if (j == 0) {
                    sums[i][j] = sums[i - 1][j] + grid[i][j];
                } else {
                    sums[i][j] = (Math.min(sums[i - 1][j], sums[i][j - 1])) + grid[i][j];
                }
            }
        }

        return sums[m - 1][n - 1];
    }
}
