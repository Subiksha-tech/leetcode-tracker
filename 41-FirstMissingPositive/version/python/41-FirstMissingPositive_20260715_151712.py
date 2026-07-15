# Last updated: 15/07/2026, 15:17:12
1class Solution:
2    def firstMissingPositive(self, nums: list[int]) -> int:
3        n = len(nums)
4
5        # Place each number in its correct position
6        for i in range(n):
7            while (
8                1 <= nums[i] <= n
9                and nums[nums[i] - 1] != nums[i]
10            ):
11                correct = nums[i] - 1
12                nums[i], nums[correct] = nums[correct], nums[i]
13
14        # Find the first missing positive
15        for i in range(n):
16            if nums[i] != i + 1:
17                return i + 1
18
19        return n + 1
20        