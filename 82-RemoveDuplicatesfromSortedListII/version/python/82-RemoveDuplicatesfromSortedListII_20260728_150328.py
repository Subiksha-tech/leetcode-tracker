# Last updated: 28/07/2026, 15:03:28
1
2
3class Solution:
4    def deleteDuplicates(self, head: Optional[ListNode]) -> Optional[ListNode]:
5        dummy = ListNode(0)
6        dummy.next = head
7
8        prev = dummy
9        curr = head
10
11        while curr:
12
13            if curr.next and curr.val == curr.next.val:
14                while curr.next and curr.val == curr.next.val:
15                    curr = curr.next
16                prev.next = curr.next
17            else:
18                prev = prev.next
19
20            curr = curr.next
21
22        return dummy.next