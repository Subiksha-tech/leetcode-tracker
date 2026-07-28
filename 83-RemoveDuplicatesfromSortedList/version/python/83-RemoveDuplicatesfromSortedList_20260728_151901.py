# Last updated: 28/07/2026, 15:19:01
1class Solution:
2    def subsetsWithDup(self, nums: List[int]) -> List[List[int]]:
3        nums.sort()
4        result = []
5
6        def backtrack(start, subset):
7            result.append(subset[:])
8
9            for i in range(start, len(nums)):
10                if i > start and nums[i] == nums[i - 1]:
11                    continue
12
13                subset.append(nums[i])
14                backtrack(i + 1, subset)
15                subset.pop()
16
17        backtrack(0, [])
18        return result