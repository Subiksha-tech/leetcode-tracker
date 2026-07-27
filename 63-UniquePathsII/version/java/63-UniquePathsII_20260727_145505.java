// Last updated: 27/07/2026, 14:55:05
1class Solution {
2    public int minPathSum(int[][] grid) {
3
4        int m = grid.length;
5        int n = grid[0].length;
6
7        int[][] dp = new int[m][n];
8
9        dp[0][0] = grid[0][0];
10
11        // First row
12        for (int j = 1; j < n; j++)
13            dp[0][j] = dp[0][j - 1] + grid[0][j];
14
15        // First column
16        for (int i = 1; i < m; i++)
17            dp[i][0] = dp[i - 1][0] + grid[i][0];
18
19        // Remaining cells
20        for (int i = 1; i < m; i++) {
21            for (int j = 1; j < n; j++) {
22                dp[i][j] = grid[i][j] +
23                           Math.min(dp[i - 1][j], dp[i][j - 1]);
24            }
25        }
26
27        return dp[m - 1][n - 1];
28    }
29}