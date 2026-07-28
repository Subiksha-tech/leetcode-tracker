# Last updated: 28/07/2026, 15:48:48
1class Solution:
2    def maxPathSum(self, root: Optional[TreeNode]) -> int:
3        self.ans = float('-inf')
4
5        def dfs(node):
6            if not node:
7                return 0
8
9            left = max(dfs(node.left), 0)
10            right = max(dfs(node.right), 0)
11
12            self.ans = max(self.ans, node.val + left + right)
13
14            return node.val + max(left, right)
15
16        dfs(root)
17        return self.ans