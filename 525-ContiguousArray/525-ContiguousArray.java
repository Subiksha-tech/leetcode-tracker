// Last updated: 09/07/2026, 10:06:46
import java.util.*;

class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(0, -1); // sum 0 before array starts

        int sum = 0;
        int maxLen = 0;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == 0)
                sum += -1;
            else
                sum += 1;

            if (map.containsKey(sum)) {
                maxLen = Math.max(maxLen, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }

        return maxLen;
    }
}