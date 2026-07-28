# Last updated: 28/07/2026, 15:50:09
1from collections import defaultdict
2
3class Solution:
4    def findLadders(self, beginWord: str, endWord: str, wordList: List[str]) -> List[List[str]]:
5        wordSet = set(wordList)
6        if endWord not in wordSet:
7            return []
8
9        parents = defaultdict(list)
10        level = {beginWord}
11        found = False
12
13        while level and not found:
14            next_level = defaultdict(list)
15            wordSet -= level
16
17            for word in level:
18                for i in range(len(word)):
19                    for c in "abcdefghijklmnopqrstuvwxyz":
20                        new_word = word[:i] + c + word[i + 1:]
21
22                        if new_word in wordSet:
23                            next_level[new_word].append(word)
24
25                            if new_word == endWord:
26                                found = True
27
28            for word, prevs in next_level.items():
29                parents[word].extend(prevs)
30
31            level = set(next_level.keys())
32
33        if not found:
34            return []
35
36        result = []
37
38        def dfs(word, path):
39            if word == beginWord:
40                result.append(path[::-1])
41                return
42
43            for parent in parents[word]:
44                dfs(parent, path + [parent])
45
46        dfs(endWord, [endWord])
47
48        return result