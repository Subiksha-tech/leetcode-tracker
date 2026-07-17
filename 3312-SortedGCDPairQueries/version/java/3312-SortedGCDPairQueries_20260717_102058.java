// Last updated: 17/07/2026, 10:20:58
1class Solution {
2    public int[] gcdValues(int[] nums, long[] queries) {
3        int max = 0;
4        for (int x : nums) max = Math.max(max, x);
5
6        int[] freq = new int[max + 1];
7        for (int x : nums) freq[x]++;
8
9        // cnt[d] = numbers divisible by d
10        long[] cnt = new long[max + 1];
11
12        for (int d = 1; d <= max; d++) {
13            for (int multiple = d; multiple <= max; multiple += d) {
14                cnt[d] += freq[multiple];
15            }
16        }
17
18        // exact[d] = pairs with gcd exactly d
19        long[] exact = new long[max + 1];
20
21        for (int d = max; d >= 1; d--) {
22            long pairs = cnt[d] * (cnt[d] - 1) / 2;
23
24            for (int multiple = d + d; multiple <= max; multiple += d) {
25                pairs -= exact[multiple];
26            }
27
28            exact[d] = pairs;
29        }
30
31        long[] prefix = new long[max + 1];
32        for (int i = 1; i <= max; i++) {
33            prefix[i] = prefix[i - 1] + exact[i];
34        }
35
36        int[] ans = new int[queries.length];
37
38        for (int i = 0; i < queries.length; i++) {
39            long k = queries[i];
40
41            int lo = 1;
42            int hi = max;
43
44            while (lo < hi) {
45                int mid = (lo + hi) / 2;
46
47                if (prefix[mid] > k)
48                    hi = mid;
49                else
50                    lo = mid + 1;
51            }
52
53            ans[i] = lo;
54        }
55
56        return ans;
57    }
58}