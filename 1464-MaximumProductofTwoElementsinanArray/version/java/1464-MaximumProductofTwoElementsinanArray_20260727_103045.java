// Last updated: 27/07/2026, 10:30:45
1class Solution {
2    public int maxProduct(int[] nums) {
3
4        int max1 = 0;
5        int max2 = 0;
6
7        for (int num : nums) {
8            if (num > max1) {
9                max2 = max1;
10                max1 = num;
11            } else if (num > max2) {
12                max2 = num;
13            }
14        }
15
16        return (max1 - 1) * (max2 - 1);
17    }
18}