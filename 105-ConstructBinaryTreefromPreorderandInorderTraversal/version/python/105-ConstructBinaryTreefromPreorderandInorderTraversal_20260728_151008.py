# Last updated: 28/07/2026, 15:10:08
1from collections import deque
2
3
4class Solution:
5    def levelOrderBottom(self, root: Optional[TreeNode]) -> List[List[int]]:
6        if not root:
7            return []
8
9        queue = deque([root])
10        result = []
11
12        while queue:
13            level = []
14
15            for _ in range(len(queue)):
16                node = queue.popleft()
17                level.append(node.val)
18
19                if node.left:
20                    queue.append(node.left)
21                if node.right:
22                    queue.append(node.right)
23
24            result.append(level)
25
26        return result[::-1]