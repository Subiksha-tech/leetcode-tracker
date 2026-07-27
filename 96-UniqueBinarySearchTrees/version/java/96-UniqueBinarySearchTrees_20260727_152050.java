// Last updated: 27/07/2026, 15:20:50
1class Solution {
2    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
3
4        List<List<Integer>> ans = new ArrayList<>();
5
6        if (root == null)
7            return ans;
8
9        Queue<TreeNode> queue = new LinkedList<>();
10        queue.offer(root);
11
12        boolean leftToRight = true;
13
14        while (!queue.isEmpty()) {
15
16            int size = queue.size();
17            LinkedList<Integer> level = new LinkedList<>();
18
19            for (int i = 0; i < size; i++) {
20
21                TreeNode node = queue.poll();
22
23                if (leftToRight)
24                    level.addLast(node.val);
25                else
26                    level.addFirst(node.val);
27
28                if (node.left != null)
29                    queue.offer(node.left);
30
31                if (node.right != null)
32                    queue.offer(node.right);
33            }
34
35            ans.add(level);
36
37            leftToRight = !leftToRight;
38        }
39
40        return ans;
41    }
42}