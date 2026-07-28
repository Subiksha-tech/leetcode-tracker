# Last updated: 28/07/2026, 15:16:45
1from functools import lru_cache
2
3class Solution:
4    def isScramble(self, s1: str, s2: str) -> bool:
5
6        @lru_cache(None)
7        def dfs(a, b):
8            if a == b:
9                return True
10
11            if sorted(a) != sorted(b):
12                return False
13
14            n = len(a)
15
16            for i in range(1, n):
17                if dfs(a[:i], b[:i]) and dfs(a[i:], b[i:]):
18                    return True
19
20                if dfs(a[:i], b[n-i:]) and dfs(a[i:], b[:n-i]):
21                    return True
22
23            return False
24
25        return dfs(s1, s2)