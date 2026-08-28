// Last updated: 28/08/2026, 09:14:01
1/**
2 * Definition for a binary tree node.
3 * struct TreeNode {
4 *     int val;
5 *     struct TreeNode *left;
6 *     struct TreeNode *right;
7 * };
8 */
9
10/**
11 * Note: The returned array must be malloced, assume caller calls free().
12 */
13
14int* postorderTraversal(struct TreeNode* root, int* returnSize) {
15    int* result = (int*)malloc(100 * sizeof(int));
16    *returnSize = 0;
17
18    if (root == NULL)
19        return result;
20
21    struct TreeNode* stack1[100];
22    struct TreeNode* stack2[100];
23
24    int top1 = -1;
25    int top2 = -1;
26
27    stack1[++top1] = root;
28
29    while (top1 >= 0) {
30        struct TreeNode* node = stack1[top1--];
31
32        stack2[++top2] = node;
33
34        if (node->left != NULL)
35            stack1[++top1] = node->left;
36
37        if (node->right != NULL)
38            stack1[++top1] = node->right;
39    }
40
41    while (top2 >= 0) {
42        result[(*returnSize)++] = stack2[top2--]->val;
43    }
44
45    return result;
46}