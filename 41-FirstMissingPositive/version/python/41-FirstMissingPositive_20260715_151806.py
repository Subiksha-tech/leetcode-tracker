# Last updated: 15/07/2026, 15:18:06
1class Solution:
2    def trap(self, height: list[int]) -> int:
3        left, right = 0, len(height) - 1
4        leftMax = rightMax = 0
5        water = 0
6
7        while left < right:
8            if height[left] < height[right]:
9                if height[left] >= leftMax:
10                    leftMax = height[left]
11                else:
12                    water += leftMax - height[left]
13                left += 1
14            else:
15                if height[right] >= rightMax:
16                    rightMax = height[right]
17                else:
18                    water += rightMax - height[right]
19                right -= 1
20
21        return water
22        