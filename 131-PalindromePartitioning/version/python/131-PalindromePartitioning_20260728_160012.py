# Last updated: 28/07/2026, 16:00:12
1class Solution:
2    def cloneGraph(self, node: 'Node') -> 'Node':
3        if not node:
4            return None
5
6        clones = {}
7
8        def dfs(curr):
9            if curr in clones:
10                return clones[curr]
11
12            copy = Node(curr.val)
13            clones[curr] = copy
14
15            for neighbor in curr.neighbors:
16                copy.neighbors.append(dfs(neighbor))
17
18            return copy
19
20        return dfs(node)