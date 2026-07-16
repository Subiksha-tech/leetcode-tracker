# Last updated: 16/07/2026, 09:16:33
1from typing import List
2
3class Solution:
4    def canJump(self, nums: List[int]) -> bool:
5        farthest = 0
6
7        for i in range(len(nums)):
8            if i > farthest:
9                return False
10
11            farthest = max(farthest, i + nums[i])
12
13            if farthest >= len(nums) - 1:
14                return True
15
16        return True
17        