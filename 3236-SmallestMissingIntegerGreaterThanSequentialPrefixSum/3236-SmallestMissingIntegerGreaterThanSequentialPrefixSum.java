// Last updated: 09/07/2026, 10:06:29
import java.util.*;

class Solution {
    public int missingInteger(int[] nums) {
        int sum = nums[0];

        // Find the longest sequential prefix and its sum
        int i = 1;
        while (i < nums.length && nums[i] == nums[i - 1] + 1) {
            sum += nums[i];
            i++;
        }

        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        // Find the smallest missing integer >= sum
        while (set.contains(sum)) {
            sum++;
        }

        return sum;
    }
}