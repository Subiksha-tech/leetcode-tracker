# Last updated: 28/07/2026, 16:09:19
1class Solution:
2    def singleNumber(self, nums: List[int]) -> int:
3        ans = 0
4
5        for num in nums:
6            ans ^= num
7
8        return ans