// Last updated: 15/07/2026, 09:32:11
1/**
2 * Definition for singly-linked list.
3 * public class ListNode {
4 *     int val;
5 *     ListNode next;
6 *     ListNode() {}
7 *     ListNode(int val) { this.val = val; }
8 *     ListNode(int val, ListNode next) {
9 *         this.val = val;
10 *         this.next = next;
11 *     }
12 * }
13 */
14
15class Solution {
16    public ListNode swapPairs(ListNode head) {
17
18        ListNode dummy = new ListNode(0);
19        dummy.next = head;
20
21        ListNode prev = dummy;
22
23        while (prev.next != null && prev.next.next != null) {
24
25            ListNode first = prev.next;
26            ListNode second = first.next;
27
28            // Swap
29            first.next = second.next;
30            second.next = first;
31            prev.next = second;
32
33            // Move to the next pair
34            prev = first;
35        }
36
37        return dummy.next;
38    }
39}