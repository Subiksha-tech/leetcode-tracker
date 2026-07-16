# Last updated: 16/07/2026, 08:57:39
1class Solution:
2    def jump(self, nums):
3        jumps = 0
4        current_end = 0
5        farthest = 0
6
7        # No need to process the last index
8        for i in range(len(nums) - 1):
9            farthest = max(farthest, i + nums[i])
10
11            # End of current jump range
12            if i == current_end:
13                jumps += 1
14                current_end = farthest
15
16        return jumps
17        