# Last updated: 28/07/2026, 15:02:25
1class Solution:
2    def search(self, nums: List[int], target: int) -> bool:
3        left, right = 0, len(nums) - 1
4
5        while left <= right:
6            mid = (left + right) // 2
7
8            if nums[mid] == target:
9                return True
10
11            if nums[left] == nums[mid] == nums[right]:
12                left += 1
13                right -= 1
14
15            elif nums[left] <= nums[mid]:
16                if nums[left] <= target < nums[mid]:
17                    right = mid - 1
18                else:
19                    left = mid + 1
20
21            else:
22                if nums[mid] < target <= nums[right]:
23                    left = mid + 1
24                else:
25                    right = mid - 1
26
27        return False