// Last updated: 28/08/2026, 09:29:31
1/**
2 * Definition for singly-linked list.
3 * struct ListNode {
4 *     int val;
5 *     struct ListNode *next;
6 * };
7 */
8
9struct ListNode* insertionSortList(struct ListNode* head) {
10
11    if (head == NULL || head->next == NULL)
12        return head;
13
14    // Dummy node to make insertion easier
15    struct ListNode dummy;
16    dummy.next = NULL;
17
18    struct ListNode* current = head;
19
20    while (current != NULL) {
21
22        // Save the next node
23        struct ListNode* next = current->next;
24
25        // Find the correct position
26        struct ListNode* prev = &dummy;
27
28        while (prev->next != NULL &&
29               prev->next->val < current->val) {
30            prev = prev->next;
31        }
32
33        // Insert current node
34        current->next = prev->next;
35        prev->next = current;
36
37        // Move to next input node
38        current = next;
39    }
40
41    return dummy.next;
42}