# Last updated: 28/07/2026, 15:43:36
1
2class Solution:
3    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
4        dummy = ListNode(0)
5        dummy.next = head
6
7        fast = dummy
8        slow = dummy
9
10        for _ in range(n + 1):
11            fast = fast.next
12
13        while fast:
14            fast = fast.next
15            slow = slow.next
16
17        slow.next = slow.next.next
18
19        return dummy.next