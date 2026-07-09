// Last updated: 09/07/2026, 10:06:19
import java.util.*;

class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        HashMap<Long, Long> minPrefix = new HashMap<>();

        long prefix = 0;
        long ans = Long.MIN_VALUE;

        for (int num : nums) {
            long x = num;

            if (minPrefix.containsKey(x - k)) {
                ans = Math.max(ans,
                        prefix + x - minPrefix.get(x - k));
            }

            if (minPrefix.containsKey(x + k)) {
                ans = Math.max(ans,
                        prefix + x - minPrefix.get(x + k));
            }

            minPrefix.put(x,
                    Math.min(
                            minPrefix.getOrDefault(x, Long.MAX_VALUE),
                            prefix));

            prefix += x;
        }

        return ans == Long.MIN_VALUE ? 0 : ans;
    }
}