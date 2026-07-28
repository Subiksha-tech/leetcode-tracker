# Last updated: 28/07/2026, 15:39:40
1
2class Solution:
3    def flatten(self, root: Optional[TreeNode]) -> None:
4        if not root:
5            return
6
7        self.flatten(root.left)
8        self.flatten(root.right)
9
10        left = root.left
11        right = root.right
12
13        root.left = None
14        root.right = left
15
16        curr = root
17        while curr.right:
18            curr = curr.right
19
20        curr.right = right