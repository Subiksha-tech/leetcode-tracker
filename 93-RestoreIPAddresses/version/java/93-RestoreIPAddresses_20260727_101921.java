// Last updated: 27/07/2026, 10:19:21
1class Solution {
2    List<Integer> result = new ArrayList<>();
3
4    public List<Integer> inorderTraversal(TreeNode root) {
5        inorder(root);
6        return result;
7    }
8
9    private void inorder(TreeNode node) {
10        if (node == null)
11            return;
12
13        inorder(node.left);      // Left
14        result.add(node.val);    // Root
15        inorder(node.right);     // Right
16    }
17}