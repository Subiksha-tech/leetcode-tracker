// Last updated: 27/07/2026, 10:17:20
1class Solution {
2    public int[][] generateMatrix(int n) {
3        int[][] matrix = new int[n][n];
4
5        int top = 0;
6        int bottom = n - 1;
7        int left = 0;
8        int right = n - 1;
9
10        int num = 1;
11
12        while (top <= bottom && left <= right) {
13
14            // Left -> Right
15            for (int j = left; j <= right; j++) {
16                matrix[top][j] = num++;
17            }
18            top++;
19
20            // Top -> Bottom
21            for (int i = top; i <= bottom; i++) {
22                matrix[i][right] = num++;
23            }
24            right--;
25
26            // Right -> Left
27            if (top <= bottom) {
28                for (int j = right; j >= left; j--) {
29                    matrix[bottom][j] = num++;
30                }
31                bottom--;
32            }
33
34            // Bottom -> Top
35            if (left <= right) {
36                for (int i = bottom; i >= top; i--) {
37                    matrix[i][left] = num++;
38                }
39                left++;
40            }
41        }
42
43        return matrix;
44    }
45}