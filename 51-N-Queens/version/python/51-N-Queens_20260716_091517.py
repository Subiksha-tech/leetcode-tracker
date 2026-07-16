# Last updated: 16/07/2026, 09:15:17
1class Solution:
2    def totalNQueens(self, n: int) -> int:
3        cols = set()
4        diag1 = set()   # row - col
5        diag2 = set()   # row + col
6
7        count = 0
8
9        def backtrack(row):
10            nonlocal count
11
12            if row == n:
13                count += 1
14                return
15
16            for col in range(n):
17                if col in cols or (row - col) in diag1 or (row + col) in diag2:
18                    continue
19
20                cols.add(col)
21                diag1.add(row - col)
22                diag2.add(row + col)
23
24                backtrack(row + 1)
25
26                cols.remove(col)
27                diag1.remove(row - col)
28                diag2.remove(row + col)
29
30        backtrack(0)
31        return count
32        