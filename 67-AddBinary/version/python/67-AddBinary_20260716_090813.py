# Last updated: 16/07/2026, 09:08:13
1class Solution:
2    def climbStairs(self, n: int) -> int:
3        if n <= 2:
4            return n
5
6        first, second = 1, 2
7
8        for _ in range(3, n + 1):
9            first, second = second, first + second
10
11        return second
12        