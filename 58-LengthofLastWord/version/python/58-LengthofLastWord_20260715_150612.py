# Last updated: 15/07/2026, 15:06:12
1class Solution:
2    def lengthOfLastWord(self, s: str) -> int:
3        i = len(s) - 1
4
5        # Skip trailing spaces
6        while i >= 0 and s[i] == ' ':
7            i -= 1
8
9        length = 0
10
11        # Count the last word
12        while i >= 0 and s[i] != ' ':
13            length += 1
14            i -= 1
15
16        return length