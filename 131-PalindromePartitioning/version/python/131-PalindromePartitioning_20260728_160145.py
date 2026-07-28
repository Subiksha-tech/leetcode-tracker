# Last updated: 28/07/2026, 16:01:45
1class Solution:
2    def candy(self, ratings: List[int]) -> int:
3        n = len(ratings)
4        candies = [1] * n
5
6        for i in range(1, n):
7            if ratings[i] > ratings[i - 1]:
8                candies[i] = candies[i - 1] + 1
9
10        for i in range(n - 2, -1, -1):
11            if ratings[i] > ratings[i + 1]:
12                candies[i] = max(candies[i], candies[i + 1] + 1)
13
14        return sum(candies)