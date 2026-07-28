# Last updated: 28/07/2026, 15:50:53
1from collections import deque
2
3class Solution:
4    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
5        wordSet = set(wordList)
6
7        if endWord not in wordSet:
8            return 0
9
10        queue = deque([(beginWord, 1)])
11
12        while queue:
13            word, length = queue.popleft()
14
15            if word == endWord:
16                return length
17
18            for i in range(len(word)):
19                for c in "abcdefghijklmnopqrstuvwxyz":
20                    new_word = word[:i] + c + word[i + 1:]
21
22                    if new_word in wordSet:
23                        queue.append((new_word, length + 1))
24                        wordSet.remove(new_word)
25
26        return 0