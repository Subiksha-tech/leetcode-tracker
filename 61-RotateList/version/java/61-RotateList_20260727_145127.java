// Last updated: 27/07/2026, 14:51:27
1class Solution {
2    public ListNode rotateRight(ListNode head, int k) {
3        if (head == null || head.next == null || k == 0)
4            return head;
5
6        // Find length and last node
7        int length = 1;
8        ListNode tail = head;
9
10        while (tail.next != null) {
11            tail = tail.next;
12            length++;
13        }
14
15        k %= length;
16
17        if (k == 0)
18            return head;
19
20        // Make circular list
21        tail.next = head;
22
23        // Find new tail
24        int steps = length - k;
25        ListNode newTail = head;
26
27        for (int i = 1; i < steps; i++) {
28            newTail = newTail.next;
29        }
30
31        // New head
32        ListNode newHead = newTail.next;
33
34        // Break the circle
35        newTail.next = null;
36
37        return newHead;
38    }
39}