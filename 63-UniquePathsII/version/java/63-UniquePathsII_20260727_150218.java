// Last updated: 27/07/2026, 15:02:18
1class Solution {
2    public String simplifyPath(String path) {
3
4        Deque<String> stack = new ArrayDeque<>();
5
6        String[] parts = path.split("/");
7
8        for (String part : parts) {
9
10            if (part.equals("") || part.equals(".")) {
11                continue;
12            }
13
14            if (part.equals("..")) {
15                if (!stack.isEmpty()) {
16                    stack.removeLast();
17                }
18            } else {
19                stack.addLast(part);
20            }
21        }
22
23        if (stack.isEmpty()) {
24            return "/";
25        }
26
27        StringBuilder ans = new StringBuilder();
28
29        while (!stack.isEmpty()) {
30            ans.append("/").append(stack.removeFirst());
31        }
32
33        return ans.toString();
34    }
35}