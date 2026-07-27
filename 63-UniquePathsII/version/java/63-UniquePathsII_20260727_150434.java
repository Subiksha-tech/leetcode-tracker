// Last updated: 27/07/2026, 15:04:34
1class Solution {
2    public boolean searchMatrix(int[][] matrix, int target) {
3
4        int m = matrix.length;
5        int n = matrix[0].length;
6
7        int low = 0;
8        int high = m * n - 1;
9
10        while (low <= high) {
11
12            int mid = low + (high - low) / 2;
13
14            int row = mid / n;
15            int col = mid % n;
16
17            if (matrix[row][col] == target)
18                return true;
19
20            if (matrix[row][col] < target)
21                low = mid + 1;
22            else
23                high = mid - 1;
24        }
25
26        return false;
27    }
28}