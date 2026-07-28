# Last updated: 28/07/2026, 15:40:24
1class Solution:
2    def numDistinct(self, s: str, t: str) -> int:
3        m, n = len(s), len(t)
4
5        dp = [[0] * (n + 1) for _ in range(m + 1)]
6
7        for i in range(m + 1):
8            dp[i][0] = 1
9
10        for i in range(1, m + 1):
11            for j in range(1, n + 1):
12                if s[i - 1] == t[j - 1]:
13                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j]
14                else:
15                    dp[i][j] = dp[i - 1][j]
16
17        return dp[m][n]