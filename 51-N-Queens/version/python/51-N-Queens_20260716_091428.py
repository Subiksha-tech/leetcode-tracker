# Last updated: 16/07/2026, 09:14:28
1from typing import List
2
3class Solution:
4    def solveNQueens(self, n: int) -> List[List[str]]:
5        result = []
6        board = [["."] * n for _ in range(n)]
7
8        cols = set()
9        diag1 = set()   # row - col
10        diag2 = set()   # row + col
11
12        def backtrack(row):
13            if row == n:
14                result.append(["".join(r) for r in board])
15                return
16
17            for col in range(n):
18                if col in cols or (row - col) in diag1 or (row + col) in diag2:
19                    continue
20
21                # Place queen
22                board[row][col] = "Q"
23                cols.add(col)
24                diag1.add(row - col)
25                diag2.add(row + col)
26
27                backtrack(row + 1)
28
29                # Backtrack
30                board[row][col] = "."
31                cols.remove(col)
32                diag1.remove(row - col)
33                diag2.remove(row + col)
34
35        backtrack(0)
36        return result
37        