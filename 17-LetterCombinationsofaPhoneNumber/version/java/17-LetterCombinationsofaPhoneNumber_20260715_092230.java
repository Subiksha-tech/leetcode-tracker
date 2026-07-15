// Last updated: 15/07/2026, 09:22:30
1class Solution {
2
3    List<String> result = new ArrayList<>();
4
5    String[] map = {
6        "",     //0
7        "",     //1
8        "abc",  //2
9        "def",  //3
10        "ghi",  //4
11        "jkl",  //5
12        "mno",  //6
13        "pqrs", //7
14        "tuv",  //8
15        "wxyz"  //9
16    };
17
18    public List<String> letterCombinations(String digits) {
19
20        if (digits == null || digits.length() == 0)
21            return result;
22
23        backtrack(digits, 0, new StringBuilder());
24
25        return result;
26    }
27
28    private void backtrack(String digits, int index, StringBuilder current) {
29
30        // Base Case
31        if (index == digits.length()) {
32            result.add(current.toString());
33            return;
34        }
35
36        String letters = map[digits.charAt(index) - '0'];
37
38        for (char ch : letters.toCharArray()) {
39
40            current.append(ch);                 // Choose
41            backtrack(digits, index + 1, current); // Explore
42            current.deleteCharAt(current.length() - 1); // Backtrack
43        }
44    }
45}