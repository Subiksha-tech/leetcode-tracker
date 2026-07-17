// Last updated: 17/07/2026, 10:23:22
1class Solution {
2    List<List<Integer>> ans = new ArrayList<>();
3
4    public List<List<Integer>> subsetsWithDup(int[] nums) {
5        Arrays.sort(nums);
6        backtrack(0, nums, new ArrayList<>());
7        return ans;
8    }
9
10    private void backtrack(int start, int[] nums, List<Integer> curr) {
11        ans.add(new ArrayList<>(curr));
12
13        for (int i = start; i < nums.length; i++) {
14
15            // Skip duplicates at the same recursion level
16            if (i > start && nums[i] == nums[i - 1])
17                continue;
18
19            curr.add(nums[i]);
20            backtrack(i + 1, nums, curr);
21            curr.remove(curr.size() - 1);
22        }
23    }
24}