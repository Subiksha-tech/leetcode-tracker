# Last updated: 27/07/2026, 15:07:33
1class Solution:
2    def removeDuplicates(self, nums):
3        i = 0
4
5        for num in nums:
6            if i < 2 or num != nums[i - 2]:
7                nums[i] = num
8                i += 1
9
10        return i