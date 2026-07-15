# Last updated: 15/07/2026, 15:08:56
1class Solution:
2    def isValidSudoku(self, board: list[list[str]]) -> bool:
3        rows = [set() for _ in range(9)]
4        cols = [set() for _ in range(9)]
5        boxes = [set() for _ in range(9)]
6
7        for r in range(9):
8            for c in range(9):
9                if board[r][c] == ".":
10                    continue
11
12                num = board[r][c]
13                box = (r // 3) * 3 + (c // 3)
14
15                if num in rows[r] or num in cols[c] or num in boxes[box]:
16                    return False
17
18                rows[r].add(num)
19                cols[c].add(num)
20                boxes[box].add(num)
21
22        return True
23        