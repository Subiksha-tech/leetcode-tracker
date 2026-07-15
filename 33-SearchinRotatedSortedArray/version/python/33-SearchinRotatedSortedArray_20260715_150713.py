# Last updated: 15/07/2026, 15:07:13
1class Solution:
2    def search(self, nums: list[int], target: int) -> int:
3        left, right = 0, len(nums) - 1
4
5        while left <= right:
6            mid = (left + right) // 2
7
8            if nums[mid] == target:
9                return mid
10
11            # Left half is sorted
12            if nums[left] <= nums[mid]:
13                if nums[left] <= target < nums[mid]:
14                    right = mid - 1
15                else:
16                    left = mid + 1
17
18            # Right half is sorted
19            else:
20                if nums[mid] < target <= nums[right]:
21                    left = mid + 1
22                else:
23                    right = mid - 1
24
25        return -1