// Last updated: 27/07/2026, 15:18:23
1class Solution {
2    public boolean isSameTree(TreeNode p, TreeNode q) {
3
4        if (p == null && q == null)
5            return true;
6
7        if (p == null || q == null)
8            return false;
9
10        if (p.val != q.val)
11            return false;
12
13        return isSameTree(p.left, q.left) &&
14               isSameTree(p.right, q.right);
15    }
16}