# Last updated: 28/07/2026, 15:18:21
1class Solution:
2    def grayCode(self, n: int) -> List[int]:
3        result = []
4
5        for i in range(1 << n):
6            result.append(i ^ (i >> 1))
7
8        return result