// Last updated: 17/07/2026, 10:36:11
1class Solution {
2    public int numDecodings(String s) {
3        int n = s.length();
4        int[] dp = new int[n + 1];
5
6        dp[n] = 1; // Empty string
7
8        for (int i = n - 1; i >= 0; i--) {
9
10            // Cannot decode a string starting with 0
11            if (s.charAt(i) == '0') {
12                dp[i] = 0;
13                continue;
14            }
15
16            // Decode one digit
17            dp[i] = dp[i + 1];
18
19            // Decode two digits
20            if (i + 1 < n) {
21                int num = (s.charAt(i) - '0') * 10 + (s.charAt(i + 1) - '0');
22
23                if (num >= 10 && num <= 26) {
24                    dp[i] += dp[i + 2];
25                }
26            }
27        }
28
29        return dp[0];
30    }
31}