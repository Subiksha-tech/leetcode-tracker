# Last updated: 16/07/2026, 09:04:03
1from typing import List
2
3class Solution:
4    def permute(self, nums: List[int]) -> List[List[int]]:
5        result = []
6
7        def backtrack(path):
8            # If a permutation is complete
9            if len(path) == len(nums):
10                result.append(path[:])
11                return
12
13            for num in nums:
14                if num in path:
15                    continue
16
17                path.append(num)
18                backtrack(path)
19                path.pop()
20
21        backtrack([])
22        return result
23        