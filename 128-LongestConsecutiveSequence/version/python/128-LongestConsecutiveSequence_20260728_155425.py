# Last updated: 28/07/2026, 15:54:25
1class Solution:
2    def solve(self, board: List[List[str]]) -> None:
3        if not board or not board[0]:
4            return
5
6        rows, cols = len(board), len(board[0])
7
8        def dfs(r, c):
9            if r < 0 or r >= rows or c < 0 or c >= cols or board[r][c] != 'O':
10                return
11
12            board[r][c] = '#'
13
14            dfs(r + 1, c)
15            dfs(r - 1, c)
16            dfs(r, c + 1)
17            dfs(r, c - 1)
18
19        # Traverse first and last column
20        for r in range(rows):
21            dfs(r, 0)
22            dfs(r, cols - 1)
23
24        for c in range(cols):
25            dfs(0, c)
26            dfs(rows - 1, c)
27
28        for r in range(rows):
29            for c in range(cols):
30                if board[r][c] == 'O':
31                    board[r][c] = 'X'
32                elif board[r][c] == '#':
33                    board[r][c] = 'O'