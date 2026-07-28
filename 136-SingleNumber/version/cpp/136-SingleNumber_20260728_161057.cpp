// Last updated: 28/07/2026, 16:10:57
1class Solution {
2public:
3    Node* copyRandomList(Node* head) {
4        if (!head) return nullptr;
5
6        Node* curr = head;
7        while (curr) {
8            Node* copy = new Node(curr->val);
9            copy->next = curr->next;
10            curr->next = copy;
11            curr = copy->next;
12        }
13
14        curr = head;
15        while (curr) {
16            if (curr->random)
17                curr->next->random = curr->random->next;
18            curr = curr->next->next;
19        }
20
21        Node* dummy = new Node(0);
22        Node* copyCurr = dummy;
23        curr = head;
24
25        while (curr) {
26            copyCurr->next = curr->next;
27            copyCurr = copyCurr->next;
28
29            curr->next = curr->next->next;
30            curr = curr->next;
31        }
32
33        return dummy->next;
34    }
35};