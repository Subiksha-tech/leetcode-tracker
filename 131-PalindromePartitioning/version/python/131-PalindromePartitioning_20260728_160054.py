# Last updated: 28/07/2026, 16:00:54
1class Solution:
2    def canCompleteCircuit(self, gas: List[int], cost: List[int]) -> int:
3        total = 0
4        tank = 0
5        start = 0
6
7        for i in range(len(gas)):
8            diff = gas[i] - cost[i]
9            total += diff
10            tank += diff
11
12            if tank < 0:
13                start = i + 1
14                tank = 0
15
16        return start if total >= 0 else -1