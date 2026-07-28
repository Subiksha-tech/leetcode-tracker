# Last updated: 28/07/2026, 15:15:52
1
2class Solution:
3    def partition(self, head: Optional[ListNode], x: int) -> Optional[ListNode]:
4        before = ListNode(0)
5        after = ListNode(0)
6
7        before_ptr = before
8        after_ptr = after
9
10        while head:
11            if head.val < x:
12                before_ptr.next = head
13                before_ptr = before_ptr.next
14            else:
15                after_ptr.next = head
16                after_ptr = after_ptr.next
17
18            head = head.next
19
20        after_ptr.next = None
21        before_ptr.next = after.next
22
23        return before.next