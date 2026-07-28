# Last updated: 28/07/2026, 15:48:09
1class Solution:
2    def maxProfit(self, prices: List[int]) -> int:
3        buy1 = float('-inf')
4        sell1 = 0
5        buy2 = float('-inf')
6        sell2 = 0
7
8        for price in prices:
9            buy1 = max(buy1, -price)
10            sell1 = max(sell1, buy1 + price)
11            buy2 = max(buy2, sell1 - price)
12            sell2 = max(sell2, buy2 + price)
13
14        return sell2