# Last updated: 28/07/2026, 15:41:38
1from collections import defaultdict
2
3class Solution:
4    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
5        groups = defaultdict(list)
6
7        for word in strs:
8            key = "".join(sorted(word))
9            groups[key].append(word)
10
11        return list(groups.values())