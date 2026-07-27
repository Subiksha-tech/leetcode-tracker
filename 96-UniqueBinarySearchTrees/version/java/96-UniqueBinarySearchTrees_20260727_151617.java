// Last updated: 27/07/2026, 15:16:17
1class Solution {
2
3    public boolean isValidBST(TreeNode root) {
4        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
5    }
6
7    private boolean validate(TreeNode node, long min, long max) {
8
9        if (node == null)
10            return true;
11
12        if (node.val <= min || node.val >= max)
13            return false;
14
15        return validate(node.left, min, node.val) &&
16               validate(node.right, node.val, max);
17    }
18}