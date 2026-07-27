// Last updated: 27/07/2026, 10:31:43
1class Solution {
2
3    List<List<Integer>> result = new ArrayList<>();
4
5    public List<List<Integer>> subsets(int[] nums) {
6        backtrack(nums, 0, new ArrayList<>());
7        return result;
8    }
9
10    private void backtrack(int[] nums, int start, List<Integer> current) {
11
12        // Add current subset
13        result.add(new ArrayList<>(current));
14
15        // Try adding each remaining element
16        for (int i = start; i < nums.length; i++) {
17            current.add(nums[i]);
18            backtrack(nums, i + 1, current);
19            current.remove(current.size() - 1); // Backtrack
20        }
21    }
22}