# Last updated: 28/07/2026, 15:37:31
1
2class Solution:
3    def hasPathSum(self, root: Optional[TreeNode], targetSum: int) -> bool:
4        if not root:
5            return False
6
7        if not root.left and not root.right:
8            return targetSum == root.val
9
10        targetSum -= root.val
11
12        return (self.hasPathSum(root.left, targetSum) or
13                self.hasPathSum(root.right, targetSum))