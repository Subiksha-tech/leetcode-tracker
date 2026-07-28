# Last updated: 28/07/2026, 15:47:35
1class Solution:
2    def maxProfit(self, prices: List[int]) -> int:
3        profit = 0
4
5        for i in range(1, len(prices)):
6            if prices[i] > prices[i - 1]:
7                profit += prices[i] - prices[i - 1]
8
9        return profit