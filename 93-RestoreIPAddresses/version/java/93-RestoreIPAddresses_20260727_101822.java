// Last updated: 27/07/2026, 10:18:22
1class Solution {
2    List<String> result = new ArrayList<>();
3
4    public List<String> restoreIpAddresses(String s) {
5        backtrack(s, 0, new ArrayList<>());
6        return result;
7    }
8
9    private void backtrack(String s, int index, List<String> path) {
10
11        // If 4 parts are formed
12        if (path.size() == 4) {
13            if (index == s.length()) {
14                result.add(String.join(".", path));
15            }
16            return;
17        }
18
19        // Try lengths 1, 2, and 3
20        for (int len = 1; len <= 3; len++) {
21
22            if (index + len > s.length())
23                break;
24
25            String part = s.substring(index, index + len);
26
27            // Leading zero check
28            if (part.length() > 1 && part.charAt(0) == '0')
29                continue;
30
31            // Value check
32            if (Integer.parseInt(part) > 255)
33                continue;
34
35            path.add(part);
36            backtrack(s, index + len, path);
37            path.remove(path.size() - 1);
38        }
39    }
40}