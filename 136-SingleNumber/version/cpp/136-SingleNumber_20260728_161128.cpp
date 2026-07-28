// Last updated: 28/07/2026, 16:11:28
1class Solution {
2public:
3    bool wordBreak(string s, vector<string>& wordDict) {
4        unordered_set<string> words(wordDict.begin(), wordDict.end());
5        int n = s.size();
6
7        vector<bool> dp(n + 1, false);
8        dp[0] = true;
9
10        for (int i = 1; i <= n; i++) {
11            for (int j = 0; j < i; j++) {
12                if (dp[j] && words.count(s.substr(j, i - j))) {
13                    dp[i] = true;
14                    break;
15                }
16            }
17        }
18
19        return dp[n];
20    }
21};