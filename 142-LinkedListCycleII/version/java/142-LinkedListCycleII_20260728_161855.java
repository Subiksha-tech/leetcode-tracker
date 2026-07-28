// Last updated: 28/07/2026, 16:18:55
1public class Solution {
2    public ListNode detectCycle(ListNode head) {
3        ListNode slow = head;
4        ListNode fast = head;
5
6        while (fast != null && fast.next != null) {
7            slow = slow.next;
8            fast = fast.next.next;
9
10            if (slow == fast) {
11                ListNode ptr = head;
12                while (ptr != slow) {
13                    ptr = ptr.next;
14                    slow = slow.next;
15                }
16                return ptr;
17            }
18        }
19
20        return null;
21    }
22}