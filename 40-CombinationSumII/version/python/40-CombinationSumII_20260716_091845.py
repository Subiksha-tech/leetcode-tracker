# Last updated: 16/07/2026, 09:18:45
1from typing import List
2
3class Solution:
4    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:
5        candidates.sort()
6        result = []
7
8        def backtrack(start, path, remaining):
9            if remaining == 0:
10                result.append(path[:])
11                return
12
13            if remaining < 0:
14                return
15
16            for i in range(start, len(candidates)):
17                # Skip duplicates
18                if i > start and candidates[i] == candidates[i - 1]:
19                    continue
20
21                # Since sorted, no need to continue if candidate is too large
22                if candidates[i] > remaining:
23                    break
24
25                path.append(candidates[i])
26
27                # Move to the next index (each number used only once)
28                backtrack(i + 1, path, remaining - candidates[i])
29
30                path.pop()
31
32        backtrack(0, [], target)
33        return result
34        