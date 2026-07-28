# Last updated: 28/07/2026, 15:57:47
1class Solution:
2    def partition(self, s: str) -> List[List[str]]:
3        result = []
4        path = []
5
6        def isPalindrome(left, right):
7            while left < right:
8                if s[left] != s[right]:
9                    return False
10                left += 1
11                right -= 1
12            return True
13
14        def backtrack(start):
15            if start == len(s):
16                result.append(path[:])
17                return
18
19            for end in range(start, len(s)):
20                if isPalindrome(start, end):
21                    path.append(s[start:end + 1])
22                    backtrack(end + 1)
23                    path.pop()
24
25        backtrack(0)
26        return result