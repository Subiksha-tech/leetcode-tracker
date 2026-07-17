// Last updated: 17/07/2026, 10:37:21
1class Solution {
2    public ListNode reverseBetween(ListNode head, int left, int right) {
3        if (head == null || left == right)
4            return head;
5
6        ListNode dummy = new ListNode(0);
7        dummy.next = head;
8
9        // Move prev to the node before 'left'
10        ListNode prev = dummy;
11        for (int i = 1; i < left; i++) {
12            prev = prev.next;
13        }
14
15        ListNode curr = prev.next;
16        ListNode next = null;
17        ListNode prevNode = null;
18
19        // Reverse the sublist
20        for (int i = left; i <= right; i++) {
21            next = curr.next;
22            curr.next = prevNode;
23            prevNode = curr;
24            curr = next;
25        }
26
27        // Reconnect
28        prev.next.next = curr; // Tail of reversed part
29        prev.next = prevNode;  // Head of reversed part
30
31        return dummy.next;
32    }
33}