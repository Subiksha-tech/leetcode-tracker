# Last updated: 28/07/2026, 15:13:01
1
2class Solution:
3    def deleteDuplicates(self, head: Optional[ListNode]) -> Optional[ListNode]:
4        curr = head
5
6        while curr and curr.next:
7            if curr.val == curr.next.val:
8                curr.next = curr.next.next
9            else:
10                curr = curr.next
11
12        return head