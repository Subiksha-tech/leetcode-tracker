// Last updated: 09/07/2026, 10:06:28
import java.util.*;

class Solution {
    public int maxFrequencyElements(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        // Count frequencies
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int maxFreq = 0;

        // Find maximum frequency
        for (int freq : map.values()) {
            maxFreq = Math.max(maxFreq, freq);
        }

        int result = 0;

        // Sum frequencies equal to maxFreq
        for (int freq : map.values()) {
            if (freq == maxFreq) {
                result += freq;
            }
        }

        return result;
    }
}