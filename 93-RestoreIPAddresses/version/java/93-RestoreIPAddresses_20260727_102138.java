// Last updated: 27/07/2026, 10:21:38
1class Solution {
2
3    public List<TreeNode> generateTrees(int n) {
4        if (n == 0)
5            return new ArrayList<>();
6
7        return build(1, n);
8    }
9
10    private List<TreeNode> build(int start, int end) {
11
12        List<TreeNode> result = new ArrayList<>();
13
14        // Empty tree
15        if (start > end) {
16            result.add(null);
17            return result;
18        }
19
20        // Try every node as root
21        for (int i = start; i <= end; i++) {
22
23            List<TreeNode> leftTrees = build(start, i - 1);
24            List<TreeNode> rightTrees = build(i + 1, end);
25
26            // Combine every left with every right
27            for (TreeNode left : leftTrees) {
28                for (TreeNode right : rightTrees) {
29
30                    TreeNode root = new TreeNode(i);
31                    root.left = left;
32                    root.right = right;
33
34                    result.add(root);
35                }
36            }
37        }
38
39        return result;
40    }
41}