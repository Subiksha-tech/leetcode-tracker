// Last updated: 27/07/2026, 15:14:01
1class Solution {
2    public int numTrees(int n) {
3
4        int[] dp = new int[n + 1];
5
6        dp[0] = 1;
7        dp[1] = 1;
8
9        for (int nodes = 2; nodes <= n; nodes++) {
10
11            for (int root = 1; root <= nodes; root++) {
12
13                int left = root - 1;
14                int right = nodes - root;
15
16                dp[nodes] += dp[left] * dp[right];
17            }
18        }
19
20        return dp[n];
21    }
22}