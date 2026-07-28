# Last updated: 28/07/2026, 15:45:36
1
2
3class Solution:
4    def connect(self, root: 'Node') -> 'Node':
5        if not root:
6            return root
7
8        curr = root
9
10        while curr:
11            dummy = Node(0)
12            tail = dummy
13
14            while curr:
15                if curr.left:
16                    tail.next = curr.left
17                    tail = tail.next
18
19                if curr.right:
20                    tail.next = curr.right
21                    tail = tail.next
22
23                curr = curr.next
24
25            curr = dummy.next
26
27        return root