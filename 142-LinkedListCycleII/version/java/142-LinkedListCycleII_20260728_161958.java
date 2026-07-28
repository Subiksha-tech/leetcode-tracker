// Last updated: 28/07/2026, 16:19:58
1class Solution {
2    public void reorderList(ListNode head) {
3        if (head == null || head.next == null) return;
4
5        ListNode slow = head, fast = head;
6        while (fast.next != null && fast.next.next != null) {
7            slow = slow.next;
8            fast = fast.next.next;
9        }
10
11        ListNode prev = null;
12        ListNode curr = slow.next;
13        slow.next = null;
14
15        while (curr != null) {
16            ListNode next = curr.next;
17            curr.next = prev;
18            prev = curr;
19            curr = next;
20        }
21
22        ListNode first = head;
23        ListNode second = prev;
24
25        while (second != null) {
26            ListNode temp1 = first.next;
27            ListNode temp2 = second.next;
28
29            first.next = second;
30            second.next = temp1;
31
32            first = temp1;
33            second = temp2;
34        }
35    }
36}