# Last updated: 15/07/2026, 15:05:20
1class Solution:
2    def searchInsert(self, nums: list[int], target: int) -> int:
3        left, right = 0, len(nums) - 1
4
5        while left <= right:
6            mid = (left + right) // 2
7
8            if nums[mid] == target:
9                return mid
10            elif nums[mid] < target:
11                left = mid + 1
12            else:
13                right = mid - 1
14
15        return left