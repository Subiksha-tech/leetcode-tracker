# Last updated: 16/07/2026, 09:04:53
1from typing import List
2
3class Solution:
4    def permuteUnique(self, nums: List[int]) -> List[List[int]]:
5        nums.sort()
6        result = []
7        path = []
8        visited = [False] * len(nums)
9
10        def backtrack():
11            if len(path) == len(nums):
12                result.append(path[:])
13                return
14
15            for i in range(len(nums)):
16                if visited[i]:
17                    continue
18
19                # Skip duplicates
20                if i > 0 and nums[i] == nums[i - 1] and not visited[i - 1]:
21                    continue
22
23                visited[i] = True
24                path.append(nums[i])
25
26                backtrack()
27
28                path.pop()
29                visited[i] = False
30
31        backtrack()
32        return result