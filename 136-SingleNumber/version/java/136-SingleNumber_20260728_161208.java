// Last updated: 28/07/2026, 16:12:08
1class Solution {
2    public List<String> wordBreak(String s, List<String> wordDict) {
3        Set<String> dict = new HashSet<>(wordDict);
4        Map<String, List<String>> memo = new HashMap<>();
5        return dfs(s, dict, memo);
6    }
7
8    private List<String> dfs(String s, Set<String> dict, Map<String, List<String>> memo) {
9        if (memo.containsKey(s))
10            return memo.get(s);
11
12        List<String> result = new ArrayList<>();
13
14        if (s.isEmpty()) {
15            result.add("");
16            return result;
17        }
18
19        for (String word : dict) {
20            if (s.startsWith(word)) {
21                List<String> subList = dfs(s.substring(word.length()), dict, memo);
22
23                for (String sub : subList) {
24                    if (sub.isEmpty())
25                        result.add(word);
26                    else
27                        result.add(word + " " + sub);
28                }
29            }
30        }
31
32        memo.put(s, result);
33        return result;
34    }
35}