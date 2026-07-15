// Last updated: 15/07/2026, 09:24:54
1class Solution {
2    public boolean isValid(String s) {
3
4        Stack<Character> stack = new Stack<>();
5
6        for (char ch : s.toCharArray()) {
7
8            if (ch == '(' || ch == '{' || ch == '[') {
9                stack.push(ch);
10            } else {
11
12                if (stack.isEmpty())
13                    return false;
14
15                char top = stack.pop();
16
17                if (ch == ')' && top != '(')
18                    return false;
19
20                if (ch == '}' && top != '{')
21                    return false;
22
23                if (ch == ']' && top != '[')
24                    return false;
25            }
26        }
27
28        return stack.isEmpty();
29    }
30}