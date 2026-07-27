// Last updated: 27/07/2026, 14:53:47
1class Solution {
2    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
3
4        int m = obstacleGrid.length;
5        int n = obstacleGrid[0].length;
6
7        if (obstacleGrid[0][0] == 1)
8            return 0;
9
10        int[][] dp = new int[m][n];
11        dp[0][0] = 1;
12
13        for (int i = 0; i < m; i++) {
14            for (int j = 0; j < n; j++) {
15
16                if (obstacleGrid[i][j] == 1) {
17                    dp[i][j] = 0;
18                    continue;
19                }
20
21                if (i > 0)
22                    dp[i][j] += dp[i - 1][j];
23
24                if (j > 0)
25                    dp[i][j] += dp[i][j - 1];
26            }
27        }
28
29        return dp[m - 1][n - 1];
30    }
31}