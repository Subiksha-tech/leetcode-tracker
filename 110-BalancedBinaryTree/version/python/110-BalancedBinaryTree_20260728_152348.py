# Last updated: 28/07/2026, 15:23:48
1
2class Solution:
3    def isBalanced(self, root: Optional[TreeNode]) -> bool:
4        def height(node):
5            if not node:
6                return 0
7
8            left = height(node.left)
9            if left == -1:
10                return -1
11
12            right = height(node.right)
13            if right == -1:
14                return -1
15
16            if abs(left - right) > 1:
17                return -1
18
19            return 1 + max(left, right)
20
21        return height(root) != -1
22