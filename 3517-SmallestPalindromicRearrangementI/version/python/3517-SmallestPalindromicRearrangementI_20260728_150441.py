# Last updated: 28/07/2026, 15:04:41
1from collections import Counter
2
3class Solution:
4    def smallestPalindrome(self, s: str) -> str:
5        freq = Counter(s)
6
7        left = []
8        middle = ""
9
10        for ch in sorted(freq.keys()):
11            left.append(ch * (freq[ch] // 2))
12            if freq[ch] % 2 == 1:
13                middle = ch
14
15        left = "".join(left)
16        return left + middle + left[::-1]