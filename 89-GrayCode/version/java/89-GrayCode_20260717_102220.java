// Last updated: 17/07/2026, 10:22:20
1class Solution {
2    public List<Integer> grayCode(int n) {
3        List<Integer> ans = new ArrayList<>();
4
5        int total = 1 << n;
6
7        for (int i = 0; i < total; i++) {
8            ans.add(i ^ (i >> 1));
9        }
10
11        return ans;
12    }
13}