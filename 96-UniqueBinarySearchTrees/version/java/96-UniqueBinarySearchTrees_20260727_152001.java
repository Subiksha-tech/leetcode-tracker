// Last updated: 27/07/2026, 15:20:01
1class Solution {
2    public List<List<Integer>> levelOrder(TreeNode root) {
3
4        List<List<Integer>> ans = new ArrayList<>();
5
6        if (root == null)
7            return ans;
8
9        Queue<TreeNode> queue = new LinkedList<>();
10        queue.offer(root);
11
12        while (!queue.isEmpty()) {
13
14            int size = queue.size();
15            List<Integer> level = new ArrayList<>();
16
17            for (int i = 0; i < size; i++) {
18
19                TreeNode node = queue.poll();
20
21                level.add(node.val);
22
23                if (node.left != null)
24                    queue.offer(node.left);
25
26                if (node.right != null)
27                    queue.offer(node.right);
28            }
29
30            ans.add(level);
31        }
32
33        return ans;
34    }
35}