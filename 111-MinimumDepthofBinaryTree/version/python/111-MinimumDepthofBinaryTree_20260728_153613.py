# Last updated: 28/07/2026, 15:36:13
1
2
3class Solution:
4    def minDepth(self, root: Optional[TreeNode]) -> int:
5        if not root:
6            return 0
7
8        if not root.left:
9            return 1 + self.minDepth(root.right)
10
11        if not root.right:
12            return 1 + self.minDepth(root.left)
13
14        return 1 + min(self.minDepth(root.left), self.minDepth(root.right))