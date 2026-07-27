# Last updated: 27/07/2026, 15:05:32
1class Solution:
2    def sortColors(self, nums):
3        low = 0
4        mid = 0
5        high = len(nums) - 1
6
7        while mid <= high:
8            if nums[mid] == 0:
9                nums[low], nums[mid] = nums[mid], nums[low]
10                low += 1
11                mid += 1
12
13            elif nums[mid] == 1:
14                mid += 1
15
16            else:  # nums[mid] == 2
17                nums[mid], nums[high] = nums[high], nums[mid]
18                high -= 1