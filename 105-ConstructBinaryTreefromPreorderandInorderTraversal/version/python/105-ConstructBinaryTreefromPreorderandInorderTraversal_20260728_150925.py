# Last updated: 28/07/2026, 15:09:25
1
2class Solution:
3    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
4        inorder_map = {value: i for i, value in enumerate(inorder)}
5        postorder_index = len(postorder) - 1
6
7        def build(left, right):
8            nonlocal postorder_index
9
10            if left > right:
11                return None
12
13            root_val = postorder[postorder_index]
14            postorder_index -= 1
15
16            root = TreeNode(root_val)
17
18            mid = inorder_map[root_val]
19
20            root.right = build(mid + 1, right)
21
22            root.left = build(left, mid - 1)
23
24            return root
25
26        return build(0, len(inorder) - 1)