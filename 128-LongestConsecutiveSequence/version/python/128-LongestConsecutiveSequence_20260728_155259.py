# Last updated: 28/07/2026, 15:52:59
1class Solution:
2    def sumNumbers(self, root: Optional[TreeNode]) -> int:
3        def dfs(node, current):
4            if not node:
5                return 0
6
7            current = current * 10 + node.val
8
9            if not node.left and not node.right:
10                return current
11
12            return dfs(node.left, current) + dfs(node.right, current)
13
14        return dfs(root, 0)