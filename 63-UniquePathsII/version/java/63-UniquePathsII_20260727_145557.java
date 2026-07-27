// Last updated: 27/07/2026, 14:55:57
1class Solution {
2    public boolean isNumber(String s) {
3
4        boolean seenDigit = false;
5        boolean seenDot = false;
6        boolean seenExponent = false;
7
8        for (int i = 0; i < s.length(); i++) {
9
10            char c = s.charAt(i);
11
12            if (Character.isDigit(c)) {
13                seenDigit = true;
14            }
15
16            else if (c == '+' || c == '-') {
17                if (i != 0 &&
18                    s.charAt(i - 1) != 'e' &&
19                    s.charAt(i - 1) != 'E')
20                    return false;
21            }
22
23            else if (c == '.') {
24                if (seenDot || seenExponent)
25                    return false;
26                seenDot = true;
27            }
28
29            else if (c == 'e' || c == 'E') {
30                if (seenExponent || !seenDigit)
31                    return false;
32
33                seenExponent = true;
34                seenDigit = false; // Need digits after exponent
35            }
36
37            else {
38                return false;
39            }
40        }
41
42        return seenDigit;
43    }
44}