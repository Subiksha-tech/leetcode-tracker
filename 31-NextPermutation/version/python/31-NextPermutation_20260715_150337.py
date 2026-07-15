# Last updated: 15/07/2026, 15:03:37
1class Solution:
2    def nextPermutation(self, nums: list[int]) -> None:
3        n = len(nums)
4
5        # Step 1: Find the first decreasing element
6        i = n - 2
7        while i >= 0 and nums[i] >= nums[i + 1]:
8            i -= 1
9
10        # Step 2: Find the next greater element and swap
11        if i >= 0:
12            j = n - 1
13            while nums[j] <= nums[i]:
14                j -= 1
15            nums[i], nums[j] = nums[j], nums[i]
16
17        # Step 3: Reverse the remaining suffix
18        left, right = i + 1, n - 1
19        while left < right:
20            nums[left], nums[right] = nums[right], nums[left]
21            left += 1
22            right -= 1
23        