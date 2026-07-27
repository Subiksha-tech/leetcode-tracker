// Last updated: 27/07/2026, 15:19:14
1class Solution {
2
3    public boolean isSymmetric(TreeNode root) {
4        return isMirror(root.left, root.right);
5    }
6
7    private boolean isMirror(TreeNode left, TreeNode right) {
8
9        if (left == null && right == null)
10            return true;
11
12        if (left == null || right == null)
13            return false;
14
15        if (left.val != right.val)
16            return false;
17
18        return isMirror(left.left, right.right) &&
19               isMirror(left.right, right.left);
20    }
21}