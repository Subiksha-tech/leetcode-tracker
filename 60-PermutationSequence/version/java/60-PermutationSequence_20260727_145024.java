// Last updated: 27/07/2026, 14:50:24
1class Solution {
2    public String getPermutation(int n, int k) {
3        List<Integer> nums = new ArrayList<>();
4        int fact = 1;
5
6        // Store numbers and compute (n-1)!
7        for (int i = 1; i < n; i++) {
8            fact *= i;
9            nums.add(i);
10        }
11        nums.add(n);
12
13        k--; // Convert to 0-based indexing
14
15        StringBuilder ans = new StringBuilder();
16
17        while (true) {
18            int index = k / fact;
19            ans.append(nums.get(index));
20            nums.remove(index);
21
22            if (nums.size() == 0)
23                break;
24
25            k %= fact;
26            fact /= nums.size();
27        }
28
29        return ans.toString();
30    }
31}