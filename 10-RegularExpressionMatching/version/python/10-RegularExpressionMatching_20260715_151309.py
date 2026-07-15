# Last updated: 15/07/2026, 15:13:09
1class Solution:
2    def isMatch(self, s: str, p: str) -> bool:
3        memo = {}
4
5        def dp(i, j):
6            if (i, j) in memo:
7                return memo[(i, j)]
8
9            # If pattern is exhausted
10            if j == len(p):
11                return i == len(s)
12
13            # Check current character match
14            first_match = (
15                i < len(s) and
16                (s[i] == p[j] or p[j] == '.')
17            )
18
19            # Handle '*'
20            if j + 1 < len(p) and p[j + 1] == '*':
21                ans = (
22                    dp(i, j + 2) or
23                    (first_match and dp(i + 1, j))
24                )
25            else:
26                ans = first_match and dp(i + 1, j + 1)
27
28            memo[(i, j)] = ans
29            return ans
30
31        return dp(0, 0)
32        