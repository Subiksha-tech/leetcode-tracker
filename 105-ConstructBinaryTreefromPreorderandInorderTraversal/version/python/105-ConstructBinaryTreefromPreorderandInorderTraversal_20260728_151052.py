# Last updated: 28/07/2026, 15:10:52
1
2class Solution:
3    def sortedArrayToBST(self, nums: List[int]) -> Optional[TreeNode]:
4
5        def build(left, right):
6            if left > right:
7                return None
8
9            mid = (left + right) // 2
10
11            root = TreeNode(nums[mid])
12            root.left = build(left, mid - 1)
13            root.right = build(mid + 1, right)
14
15            return root
16
17        return build(0, len(nums) - 1)