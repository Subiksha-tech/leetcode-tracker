# Last updated: 16/07/2026, 08:57:00
1class Solution:
2    def combinationSum(self, candidates, target):
3        result = []
4
5        def backtrack(index, current, target):
6            # If target becomes 0, we found a valid combination
7            if target == 0:
8                result.append(current[:])
9                return
10
11            # If target becomes negative or we reach the end
12            if target < 0 or index == len(candidates):
13                return
14
15            # Choose the current candidate
16            current.append(candidates[index])
17            backtrack(index, current, target - candidates[index])
18
19            # Backtrack
20            current.pop()
21
22            # Skip the current candidate
23            backtrack(index + 1, current, target)
24
25        backtrack(0, [], target)
26        return result
27        