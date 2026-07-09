// Last updated: 09/07/2026, 10:06:32
import java.util.*;

class Solution {
    public int maximumSetSize(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = n / 2;

        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();

        for (int x : nums1) set1.add(x);
        for (int x : nums2) set2.add(x);

        int common = 0;

        for (int x : set1) {
            if (set2.contains(x)) {
                common++;
            }
        }

        int only1 = set1.size() - common;
        int only2 = set2.size() - common;

        int take1 = Math.min(only1, m);
        int take2 = Math.min(only2, m);

        int rem1 = m - take1;
        int rem2 = m - take2;

        return take1 + take2 + Math.min(common, rem1 + rem2);
    }
}