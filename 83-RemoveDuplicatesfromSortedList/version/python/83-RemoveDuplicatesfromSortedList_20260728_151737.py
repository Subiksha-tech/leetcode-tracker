# Last updated: 28/07/2026, 15:17:37
1class Solution:
2    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
3        i = m - 1
4        j = n - 1
5        k = m + n - 1
6
7        while i >= 0 and j >= 0:
8            if nums1[i] > nums2[j]:
9                nums1[k] = nums1[i]
10                i -= 1
11            else:
12                nums1[k] = nums2[j]
13                j -= 1
14            k -= 1
15
16        while j >= 0:
17            nums1[k] = nums2[j]
18            j -= 1
19            k -= 1