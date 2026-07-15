# Last updated: 15/07/2026, 15:16:08
1class Solution:
2    def countAndSay(self, n: int) -> str:
3        result = "1"
4
5        for _ in range(n - 1):
6            temp = ""
7            count = 1
8
9            for i in range(1, len(result)):
10                if result[i] == result[i - 1]:
11                    count += 1
12                else:
13                    temp += str(count) + result[i - 1]
14                    count = 1
15
16            # Add the last group
17            temp += str(count) + result[-1]
18            result = temp
19
20        return result
21        