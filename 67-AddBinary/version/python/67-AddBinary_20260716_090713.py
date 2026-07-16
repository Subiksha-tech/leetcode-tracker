# Last updated: 16/07/2026, 09:07:13
1class Solution:
2    def addBinary(self, a: str, b: str) -> str:
3        i = len(a) - 1
4        j = len(b) - 1
5        carry = 0
6        result = []
7
8        while i >= 0 or j >= 0 or carry:
9            total = carry
10
11            if i >= 0:
12                total += int(a[i])
13                i -= 1
14
15            if j >= 0:
16                total += int(b[j])
17                j -= 1
18
19            result.append(str(total % 2))
20            carry = total // 2
21
22        return "".join(result[::-1])
23        