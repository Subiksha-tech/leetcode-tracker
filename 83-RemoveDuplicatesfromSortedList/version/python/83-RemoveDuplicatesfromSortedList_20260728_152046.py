# Last updated: 28/07/2026, 15:20:46
1
2class Solution:
3    def reverseBetween(self, head: Optional[ListNode], left: int, right: int) -> Optional[ListNode]:
4        if not head or left == right:
5            return head
6
7        dummy = ListNode(0)
8        dummy.next = head
9        prev = dummy
10
11        for _ in range(left - 1):
12            prev = prev.next
13
14        curr = prev.next
15
16        for _ in range(right - left):
17            temp = curr.next
18            curr.next = temp.next
19            temp.next = prev.next
20            prev.next = temp
21
22        return dummy.next