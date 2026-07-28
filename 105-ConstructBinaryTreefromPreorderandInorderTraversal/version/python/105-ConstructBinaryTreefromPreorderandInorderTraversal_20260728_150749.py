# Last updated: 28/07/2026, 15:07:49
1
2class Solution:
3    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
4        inorder_map = {value: i for i, value in enumerate(inorder)}
5        preorder_index = 0
6
7        def build(left, right):
8            nonlocal preorder_index
9
10            if left > right:
11                return None
12
13            root_val = preorder[preorder_index]
14            preorder_index += 1
15
16            root = TreeNode(root_val)
17
18            mid = inorder_map[root_val]
19
20            root.left = build(left, mid - 1)
21
22            root.right = build(mid + 1, right)
23
24            return root
25
26        return build(0, len(inorder) - 1)