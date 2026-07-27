// Last updated: 27/07/2026, 14:57:29
1class Solution {
2    public List<String> fullJustify(String[] words, int maxWidth) {
3
4        List<String> ans = new ArrayList<>();
5        int i = 0;
6
7        while (i < words.length) {
8
9            int j = i;
10            int lineLength = 0;
11
12            // Greedily fit as many words as possible
13            while (j < words.length &&
14                    lineLength + words[j].length() + (j - i) <= maxWidth) {
15
16                lineLength += words[j].length();
17                j++;
18            }
19
20            int gaps = j - i - 1;
21            StringBuilder line = new StringBuilder();
22
23            // Last line or single word
24            if (j == words.length || gaps == 0) {
25
26                for (int k = i; k < j; k++) {
27                    line.append(words[k]);
28
29                    if (k != j - 1)
30                        line.append(" ");
31                }
32
33                while (line.length() < maxWidth)
34                    line.append(" ");
35
36            } else {
37
38                int totalSpaces = maxWidth - lineLength;
39                int spaceEach = totalSpaces / gaps;
40                int extra = totalSpaces % gaps;
41
42                for (int k = i; k < j; k++) {
43
44                    line.append(words[k]);
45
46                    if (k != j - 1) {
47
48                        for (int s = 0; s < spaceEach; s++)
49                            line.append(" ");
50
51                        if (extra > 0) {
52                            line.append(" ");
53                            extra--;
54                        }
55                    }
56                }
57            }
58
59            ans.add(line.toString());
60            i = j;
61        }
62
63        return ans;
64    }
65}