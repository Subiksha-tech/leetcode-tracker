# Last updated: 28/07/2026, 15:46:17
1class Solution:
2    def minimumTotal(self, triangle: List[List[int]]) -> int:
3        dp = triangle[-1][:]
4
5        for i in range(len(triangle) - 2, -1, -1):
6            for j in range(len(triangle[i])):
7                dp[j] = triangle[i][j] + min(dp[j], dp[j + 1])
8
9        return dp[0]