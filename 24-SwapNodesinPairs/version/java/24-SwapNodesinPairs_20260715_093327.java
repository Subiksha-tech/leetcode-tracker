// Last updated: 15/07/2026, 09:33:27
1class Solution {
2
3    public ListNode reverseKGroup(ListNode head, int k) {
4
5        ListNode dummy = new ListNode(0);
6        dummy.next = head;
7
8        ListNode groupPrev = dummy;
9
10        while (true) {
11
12            // Find the kth node
13            ListNode kth = getKth(groupPrev, k);
14
15            if (kth == null)
16                break;
17
18            ListNode groupNext = kth.next;
19
20            // Reverse the group
21            ListNode prev = groupNext;
22            ListNode curr = groupPrev.next;
23
24            while (curr != groupNext) {
25                ListNode temp = curr.next;
26                curr.next = prev;
27                prev = curr;
28                curr = temp;
29            }
30
31            // Reconnect the reversed group
32            ListNode temp = groupPrev.next;
33            groupPrev.next = kth;
34            groupPrev = temp;
35        }
36
37        return dummy.next;
38    }
39
40    private ListNode getKth(ListNode curr, int k) {
41        while (curr != null && k > 0) {
42            curr = curr.next;
43            k--;
44        }
45        return curr;
46    }
47}