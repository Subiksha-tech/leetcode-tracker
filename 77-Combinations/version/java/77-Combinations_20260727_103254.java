// Last updated: 27/07/2026, 10:32:54
1class Solution {
2
3    public boolean exist(char[][] board, String word) {
4
5        int rows = board.length;
6        int cols = board[0].length;
7
8        for (int i = 0; i < rows; i++) {
9            for (int j = 0; j < cols; j++) {
10
11                if (dfs(board, word, i, j, 0))
12                    return true;
13            }
14        }
15
16        return false;
17    }
18
19    private boolean dfs(char[][] board, String word, int row, int col, int index) {
20
21        // Entire word found
22        if (index == word.length())
23            return true;
24
25        // Out of bounds or character doesn't match
26        if (row < 0 || col < 0 ||
27            row >= board.length || col >= board[0].length ||
28            board[row][col] != word.charAt(index))
29            return false;
30
31        // Mark as visited
32        char temp = board[row][col];
33        board[row][col] = '#';
34
35        // Explore 4 directions
36        boolean found =
37                dfs(board, word, row + 1, col, index + 1) ||
38                dfs(board, word, row - 1, col, index + 1) ||
39                dfs(board, word, row, col + 1, index + 1) ||
40                dfs(board, word, row, col - 1, index + 1);
41
42        // Backtrack
43        board[row][col] = temp;
44
45        return found;
46    }
47}