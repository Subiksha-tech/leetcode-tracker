// Last updated: 27/07/2026, 10:29:55
1class Solution {
2
3    List<List<Integer>> result = new ArrayList<>();
4
5    public List<List<Integer>> combine(int n, int k) {
6        backtrack(1, n, k, new ArrayList<>());
7        return result;
8    }
9
10    private void backtrack(int start, int n, int k, List<Integer> current) {
11
12        // If k numbers are chosen
13        if (current.size() == k) {
14            result.add(new ArrayList<>(current));
15            return;
16        }
17
18        // Try every possible number
19        for (int i = start; i <= n; i++) {
20            current.add(i);
21            backtrack(i + 1, n, k, current);
22            current.remove(current.size() - 1); // Backtrack
23        }
24    }
25}