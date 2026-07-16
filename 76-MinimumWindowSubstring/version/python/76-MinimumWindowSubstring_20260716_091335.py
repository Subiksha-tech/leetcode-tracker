# Last updated: 16/07/2026, 09:13:35
1from collections import Counter
2
3class Solution:
4    def minWindow(self, s: str, t: str) -> str:
5        if not s or not t:
6            return ""
7
8        need = Counter(t)
9        window = {}
10
11        have = 0
12        need_count = len(need)
13
14        left = 0
15        res = [-1, -1]
16        res_len = float("inf")
17
18        for right in range(len(s)):
19            c = s[right]
20            window[c] = window.get(c, 0) + 1
21
22            if c in need and window[c] == need[c]:
23                have += 1
24
25            while have == need_count:
26                # Update minimum window
27                if (right - left + 1) < res_len:
28                    res = [left, right]
29                    res_len = right - left + 1
30
31                # Remove left character
32                window[s[left]] -= 1
33                if s[left] in need and window[s[left]] < need[s[left]]:
34                    have -= 1
35
36                left += 1
37
38        l, r = res
39        return s[l:r+1] if res_len != float("inf") else ""
40        