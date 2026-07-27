// Last updated: 27/07/2026, 15:03:48
1class Solution {
2    public void setZeroes(int[][] matrix) {
3
4        int m = matrix.length;
5        int n = matrix[0].length;
6
7        int col0 = 1;
8
9        // First pass: mark rows and columns
10        for (int i = 0; i < m; i++) {
11
12            if (matrix[i][0] == 0)
13                col0 = 0;
14
15            for (int j = 1; j < n; j++) {
16
17                if (matrix[i][j] == 0) {
18                    matrix[i][0] = 0;
19                    matrix[0][j] = 0;
20                }
21            }
22        }
23
24        // Second pass: fill from bottom-right
25        for (int i = m - 1; i >= 0; i--) {
26
27            for (int j = n - 1; j >= 1; j--) {
28
29                if (matrix[i][0] == 0 || matrix[0][j] == 0)
30                    matrix[i][j] = 0;
31            }
32
33            if (col0 == 0)
34                matrix[i][0] = 0;
35        }
36    }
37}