# Last updated: 15/07/2026, 15:22:29
1class Solution:
2    def multiply(self, num1: str, num2: str) -> str:
3        if num1 == "0" or num2 == "0":
4            return "0"
5
6        m, n = len(num1), len(num2)
7        result = [0] * (m + n)
8
9        # Multiply from right to left
10        for i in range(m - 1, -1, -1):
11            for j in range(n - 1, -1, -1):
12                mul = (ord(num1[i]) - ord('0')) * (ord(num2[j]) - ord('0'))
13
14                p1 = i + j
15                p2 = i + j + 1
16
17                total = mul + result[p2]
18
19                result[p2] = total % 10
20                result[p1] += total // 10
21
22        # Skip leading zeros
23        ans = []
24        for num in result:
25            if not (len(ans) == 0 and num == 0):
26                ans.append(str(num))
27
28        return "".join(ans)