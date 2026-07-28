# Last updated: 28/07/2026, 15:21:36
1class Solution:
2    def restoreIpAddresses(self, s: str) -> List[str]:
3        result = []
4
5        def backtrack(start, parts):
6            if len(parts) == 4:
7                if start == len(s):
8                    result.append(".".join(parts))
9                return
10
11            for length in range(1, 4):
12                if start + length > len(s):
13                    break
14
15                part = s[start:start + length]
16
17                if len(part) > 1 and part[0] == '0':
18                    continue
19
20                if int(part) <= 255:
21                    parts.append(part)
22                    backtrack(start + length, parts)
23                    parts.pop()
24
25        backtrack(0, [])
26        return result