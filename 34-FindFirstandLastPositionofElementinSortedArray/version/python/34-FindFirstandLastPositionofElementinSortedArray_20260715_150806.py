# Last updated: 15/07/2026, 15:08:06
1class Solution:
2    def searchRange(self, nums: list[int], target: int) -> list[int]:
3
4        def findFirst():
5            left, right = 0, len(nums) - 1
6            first = -1
7
8            while left <= right:
9                mid = (left + right) // 2
10
11                if nums[mid] == target:
12                    first = mid
13                    right = mid - 1      # Search left half
14                elif nums[mid] < target:
15                    left = mid + 1
16                else:
17                    right = mid - 1
18
19            return first
20
21        def findLast():
22            left, right = 0, len(nums) - 1
23            last = -1
24
25            while left <= right:
26                mid = (left + right) // 2
27
28                if nums[mid] == target:
29                    last = mid
30                    left = mid + 1       # Search right half
31                elif nums[mid] < target:
32                    left = mid + 1
33                else:
34                    right = mid - 1
35
36            return last
37
38        return [findFirst(), findLast()]