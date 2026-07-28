# Last updated: 28/07/2026, 15:44:39
1
2class Solution:
3    def connect(self, root: 'Optional[Node]') -> 'Optional[Node]':
4        if not root:
5            return root
6
7        leftmost = root
8
9        while leftmost.left:
10            head = leftmost
11
12            while head:
13                head.left.next = head.right
14
15                if head.next:
16                    head.right.next = head.next.left
17
18                head = head.next
19
20            leftmost = leftmost.left
21
22        return root