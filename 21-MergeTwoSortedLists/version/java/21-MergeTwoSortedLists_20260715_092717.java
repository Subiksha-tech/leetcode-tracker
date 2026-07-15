// Last updated: 15/07/2026, 09:27:17
1class Solution {
2
3    List<String> result = new ArrayList<>();
4
5    public List<String> generateParenthesis(int n) {
6        backtrack("", 0, 0, n);
7        return result;
8    }
9
10    private void backtrack(String current, int open, int close, int n) {
11
12        // Base Case
13        if (current.length() == 2 * n) {
14            result.add(current);
15            return;
16        }
17
18        // Add '(' if possible
19        if (open < n) {
20            backtrack(current + "(", open + 1, close, n);
21        }
22
23        // Add ')' if possible
24        if (close < open) {
25            backtrack(current + ")", open, close + 1, n);
26        }
27    }
28}