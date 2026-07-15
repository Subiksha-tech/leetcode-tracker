// Last updated: 15/07/2026, 09:23:33
1class Solution {
2    public List<List<Integer>> fourSum(int[] nums, int target) {
3
4        List<List<Integer>> ans = new ArrayList<>();
5
6        Arrays.sort(nums);
7        int n = nums.length;
8
9        for (int i = 0; i < n - 3; i++) {
10
11            // Skip duplicate first element
12            if (i > 0 && nums[i] == nums[i - 1])
13                continue;
14
15            for (int j = i + 1; j < n - 2; j++) {
16
17                // Skip duplicate second element
18                if (j > i + 1 && nums[j] == nums[j - 1])
19                    continue;
20
21                int left = j + 1;
22                int right = n - 1;
23
24                while (left < right) {
25
26                    long sum = (long) nums[i] + nums[j]
27                             + nums[left] + nums[right];
28
29                    if (sum == target) {
30
31                        ans.add(Arrays.asList(
32                                nums[i],
33                                nums[j],
34                                nums[left],
35                                nums[right]));
36
37                        left++;
38                        right--;
39
40                        while (left < right &&
41                               nums[left] == nums[left - 1])
42                            left++;
43
44                        while (left < right &&
45                               nums[right] == nums[right + 1])
46                            right--;
47
48                    } else if (sum < target) {
49                        left++;
50                    } else {
51                        right--;
52                    }
53                }
54            }
55        }
56
57        return ans;
58    }
59}