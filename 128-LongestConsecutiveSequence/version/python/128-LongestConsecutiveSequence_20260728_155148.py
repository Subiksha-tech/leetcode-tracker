# Last updated: 28/07/2026, 15:51:48
1class Solution:
2    def longestConsecutive(self, nums: List[int]) -> int:
3        num_set = set(nums)
4        longest = 0
5
6        for num in num_set:
7
8            if num - 1 not in num_set:
9                current = num
10                length = 1
11
12                while current + 1 in num_set:
13                    current += 1
14                    length += 1
15
16                longest = max(longest, length)
17
18        return longest