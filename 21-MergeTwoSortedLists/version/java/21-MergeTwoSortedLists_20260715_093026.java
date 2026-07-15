// Last updated: 15/07/2026, 09:30:26
1class Solution {
2    public ListNode mergeKLists(ListNode[] lists) {
3
4        if (lists == null || lists.length == 0)
5            return null;
6
7        PriorityQueue<ListNode> pq =
8                new PriorityQueue<>((a, b) -> a.val - b.val);
9
10        // Add the first node of every list
11        for (ListNode node : lists) {
12            if (node != null)
13                pq.offer(node);
14        }
15
16        ListNode dummy = new ListNode(-1);
17        ListNode current = dummy;
18
19        while (!pq.isEmpty()) {
20
21            ListNode smallest = pq.poll();
22
23            current.next = smallest;
24            current = current.next;
25
26            if (smallest.next != null)
27                pq.offer(smallest.next);
28        }
29
30        return dummy.next;
31    }
32}