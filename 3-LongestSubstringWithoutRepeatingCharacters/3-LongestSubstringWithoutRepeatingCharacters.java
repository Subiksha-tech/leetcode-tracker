// Last updated: 09/07/2026, 10:07:53
class Solution {
    public int lengthOfLongestSubstring(String s) {
        java.util.HashSet<Character> set = new java.util.HashSet<>();

        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {

            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }

            set.add(s.charAt(right));
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}