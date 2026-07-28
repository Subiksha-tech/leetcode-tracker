# Last updated: 28/07/2026, 15:14:45
1class Solution:
2    def maximalRectangle(self, matrix: List[List[str]]) -> int:
3        if not matrix:
4            return 0
5
6        cols = len(matrix[0])
7        heights = [0] * cols
8        max_area = 0
9
10        for row in matrix:
11            # Build histogram
12            for j in range(cols):
13                if row[j] == "1":
14                    heights[j] += 1
15                else:
16                    heights[j] = 0
17
18            stack = []
19            temp = heights + [0]
20
21            for i, h in enumerate(temp):
22                while stack and temp[stack[-1]] > h:
23                    height = temp[stack.pop()]
24                    if stack:
25                        width = i - stack[-1] - 1
26                    else:
27                        width = i
28                    max_area = max(max_area, height * width)
29
30                stack.append(i)
31
32        return max_area