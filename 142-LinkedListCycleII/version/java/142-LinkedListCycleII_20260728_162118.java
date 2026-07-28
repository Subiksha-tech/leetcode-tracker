// Last updated: 28/07/2026, 16:21:18
1class Solution {
2    public List<Integer> preorderTraversal(TreeNode root) {
3        List<Integer> result = new ArrayList<>();
4        preorder(root, result);
5        return result;
6    }
7
8    private void preorder(TreeNode node, List<Integer> result) {
9        if (node == null) return;
10
11        result.add(node.val);
12        preorder(node.left, result);
13        preorder(node.right, result);
14    }
15}