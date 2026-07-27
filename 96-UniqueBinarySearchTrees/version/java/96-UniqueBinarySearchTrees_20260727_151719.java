// Last updated: 27/07/2026, 15:17:19
1class Solution {
2
3    TreeNode first = null;
4    TreeNode second = null;
5    TreeNode prev = null;
6
7    public void recoverTree(TreeNode root) {
8
9        inorder(root);
10
11        int temp = first.val;
12        first.val = second.val;
13        second.val = temp;
14    }
15
16    private void inorder(TreeNode node) {
17
18        if (node == null)
19            return;
20
21        inorder(node.left);
22
23        if (prev != null && prev.val > node.val) {
24
25            if (first == null) {
26                first = prev;
27            }
28
29            second = node;
30        }
31
32        prev = node;
33
34        inorder(node.right);
35    }
36}