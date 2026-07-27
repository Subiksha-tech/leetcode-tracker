// Last updated: 27/07/2026, 15:15:01
1class Solution {
2    public boolean isInterleave(String s1, String s2, String s3) {
3
4        int m = s1.length();
5        int n = s2.length();
6
7        if (m + n != s3.length())
8            return false;
9
10        boolean[][] dp = new boolean[m + 1][n + 1];
11
12        dp[0][0] = true;
13
14        for (int i = 0; i <= m; i++) {
15
16            for (int j = 0; j <= n; j++) {
17
18                if (i > 0 &&
19                    s1.charAt(i - 1) == s3.charAt(i + j - 1)) {
20                    dp[i][j] |= dp[i - 1][j];
21                }
22
23                if (j > 0 &&
24                    s2.charAt(j - 1) == s3.charAt(i + j - 1)) {
25                    dp[i][j] |= dp[i][j - 1];
26                }
27            }
28        }
29
30        return dp[m][n];
31    }
32}