# Last updated: 15/07/2026, 15:02:25
1from collections import Counter
2
3class Solution:
4    def findSubstring(self, s: str, words: list[str]) -> list[int]:
5        if not s or not words:
6            return []
7
8        word_len = len(words[0])
9        num_words = len(words)
10        total_len = word_len * num_words
11
12        word_count = Counter(words)
13        result = []
14
15        # Try each possible starting offset
16        for offset in range(word_len):
17            left = offset
18            current_count = Counter()
19            count = 0
20
21            # Move window in steps of word_len
22            for right in range(offset, len(s) - word_len + 1, word_len):
23                word = s[right:right + word_len]
24
25                if word in word_count:
26                    current_count[word] += 1
27                    count += 1
28
29                    # Remove extra occurrences
30                    while current_count[word] > word_count[word]:
31                        left_word = s[left:left + word_len]
32                        current_count[left_word] -= 1
33                        count -= 1
34                        left += word_len
35
36                    # Found a valid window
37                    if count == num_words:
38                        result.append(left)
39
40                        left_word = s[left:left + word_len]
41                        current_count[left_word] -= 1
42                        count -= 1
43                        left += word_len
44                else:
45                    # Reset window
46                    current_count.clear()
47                    count = 0
48                    left = right + word_len
49
50        return result