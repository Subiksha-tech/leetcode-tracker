# Last updated: 28/07/2026, 15:11:55
1
2
3class Solution:
4    def sortedListToBST(self, head: Optional[ListNode]) -> Optional[TreeNode]:
5
6        if not head:
7            return None
8
9        if not head.next:
10            return TreeNode(head.val)
11
12        prev = None
13        slow = fast = head
14
15        while fast and fast.next:
16            prev = slow
17            slow = slow.next
18            fast = fast.next.next
19
20        prev.next = None
21
22        root = TreeNode(slow.val)
23
24        root.left = self.sortedListToBST(head)
25        root.right = self.sortedListToBST(slow.next)
26
27        return root