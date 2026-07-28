# Last updated: 28/07/2026, 15:58:59
1class Solution:
2    def minCut(self, s: str) -> int:
3        n = len(s)
4
5        isPal = [[False] * n for _ in range(n)]
6
7        for end in range(n):
8            for start in range(end + 1):
9                if s[start] == s[end] and (end - start <= 2 or isPal[start + 1][end - 1]):
10                    isPal[start][end] = True
11
12        dp = [0] * n
13
14        for i in range(n):
15            if isPal[0][i]:
16                dp[i] = 0
17            else:
18                dp[i] = i
19                for j in range(i):
20                    if isPal[j + 1][i]:
21                        dp[i] = min(dp[i], dp[j] + 1)
22
23        return dp[-1]