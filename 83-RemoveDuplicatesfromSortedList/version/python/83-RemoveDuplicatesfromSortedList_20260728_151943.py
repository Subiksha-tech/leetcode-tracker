# Last updated: 28/07/2026, 15:19:43
1class Solution:
2    def numDecodings(self, s: str) -> int:
3        n = len(s)
4
5        if s[0] == "0":
6            return 0
7
8        dp = [0] * (n + 1)
9        dp[0] = 1
10        dp[1] = 1
11
12        for i in range(2, n + 1):
13            if s[i - 1] != "0":
14                dp[i] += dp[i - 1]
15
16            two = int(s[i - 2:i])
17            if 10 <= two <= 26:
18                dp[i] += dp[i - 2]
19
20        return dp[n]