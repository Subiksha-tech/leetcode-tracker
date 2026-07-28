# Last updated: 28/07/2026, 15:06:08
1
2class Solution:
3    def maxDepth(self, root: Optional[TreeNode]) -> int:
4        if not root:
5            return 0
6
7        left_depth = self.maxDepth(root.left)
8        right_depth = self.maxDepth(root.right)
9
10        return 1 + max(left_depth, right_depth)