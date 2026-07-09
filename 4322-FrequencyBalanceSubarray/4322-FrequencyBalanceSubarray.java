// Last updated: 09/07/2026, 10:06:24
import java.util.*;

class Solution {
    public int getLength(int[] nums) {
        int n = nums.length;

        int[] dremovical = nums.clone();

        int ans = 1;

        for (int i = 0; i < n; i++) {
            HashMap<Integer, Integer> freq = new HashMap<>();
            TreeMap<Integer, Integer> freqCount = new TreeMap<>();

            for (int j = i; j < n; j++) {
                int x = nums[j];

                int oldFreq = freq.getOrDefault(x, 0);

                if (oldFreq > 0) {
                    int count = freqCount.get(oldFreq);
                    if (count == 1) {
                        freqCount.remove(oldFreq);
                    } else {
                        freqCount.put(oldFreq, count - 1);
                    }
                }

                int newFreq = oldFreq + 1;
                freq.put(x, newFreq);
                freqCount.put(newFreq,
                        freqCount.getOrDefault(newFreq, 0) + 1);

                int len = j - i + 1;

                if (isBalanced(len, freq.size(), freqCount)) {
                    ans = Math.max(ans, len);
                }
            }
        }

        return ans;
    }

    private boolean isBalanced(int len, int distinct,
                               TreeMap<Integer, Integer> freqCount) {

        if (len == 1) return true;

        if (distinct == 1) return true;

        if (freqCount.size() != 2) return false;

        int low = freqCount.firstKey();
        int high = freqCount.lastKey();

        return high == 2 * low;
    }
}