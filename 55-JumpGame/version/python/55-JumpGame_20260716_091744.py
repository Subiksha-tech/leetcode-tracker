# Last updated: 16/07/2026, 09:17:44
1from typing import List
2
3class Solution:
4    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
5        # Sort by starting time
6        intervals.sort(key=lambda x: x[0])
7
8        merged = []
9
10        for interval in intervals:
11            if not merged or merged[-1][1] < interval[0]:
12                merged.append(interval)
13            else:
14                merged[-1][1] = max(merged[-1][1], interval[1])
15
16        return merged
17        