# Last updated: 16/07/2026, 09:02:45
1from math import gcd
2from typing import List
3
4class Solution:
5    def gcdSum(self, nums: List[int]) -> int:
6        prefixGcd = []
7        mx = 0
8
9        # Build prefixGcd
10        for num in nums:
11            mx = max(mx, num)
12            prefixGcd.append(gcd(num, mx))
13
14        # Sort the array
15        prefixGcd.sort()
16
17        # Pair smallest with largest
18        ans = 0
19        i, j = 0, len(prefixGcd) - 1
20
21        while i < j:
22            ans += gcd(prefixGcd[i], prefixGcd[j])
23            i += 1
24            j -= 1
25
26        return ans