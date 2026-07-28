# Last updated: 28/07/2026, 15:13:57
1class Solution:
2    def largestRectangleArea(self, heights: List[int]) -> int:
3        stack = []
4        max_area = 0
5
6        heights.append(0)
7
8        for i, h in enumerate(heights):
9            while stack and heights[stack[-1]] > h:
10                height = heights[stack.pop()]
11
12                if stack:
13                    width = i - stack[-1] - 1
14                else:
15                    width = i
16
17                max_area = max(max_area, height * width)
18
19            stack.append(i)
20
21        return max_area