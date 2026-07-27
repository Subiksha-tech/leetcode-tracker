// Last updated: 27/07/2026, 14:52:17
1class Solution {
2    public int uniquePaths(int m, int n) {
3        int[][] dp = new int[m][n];
4
5        // First row
6        for (int j = 0; j < n; j++)
7            dp[0][j] = 1;
8
9        // First column
10        for (int i = 0; i < m; i++)
11            dp[i][0] = 1;
12
13        // Fill remaining cells
14        for (int i = 1; i < m; i++) {
15            for (int j = 1; j < n; j++) {
16                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
17            }
18        }
19
20        return dp[m - 1][n - 1];
21    }
22}