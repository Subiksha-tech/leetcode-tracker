# Last updated: 15/07/2026, 15:25:21
1class Solution:
2    def isMatch(self, s: str, p: str) -> bool:
3        i = j = 0
4        star = -1
5        match = 0
6
7        while i < len(s):
8            # Characters match or '?'
9            if j < len(p) and (p[j] == s[i] or p[j] == '?'):
10                i += 1
11                j += 1
12
13            # Found '*'
14            elif j < len(p) and p[j] == '*':
15                star = j
16                match = i
17                j += 1
18
19            # Backtrack to last '*'
20            elif star != -1:
21                j = star + 1
22                match += 1
23                i = match
24
25            else:
26                return False
27
28        # Remaining characters in pattern must all be '*'
29        while j < len(p) and p[j] == '*':
30            j += 1
31
32        return j == len(p)
33        