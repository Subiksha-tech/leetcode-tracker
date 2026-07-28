# Last updated: 28/07/2026, 15:39:01
1
2
3class Solution:
4    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
5        result = []
6
7        def dfs(node, remaining, path):
8            if not node:
9                return
10
11            path.append(node.val)
12            remaining -= node.val
13
14            if not node.left and not node.right and remaining == 0:
15                result.append(path[:])
16            else:
17                dfs(node.left, remaining, path)
18                dfs(node.right, remaining, path)
19
20            path.pop()
21
22        dfs(root, targetSum, [])
23        return result