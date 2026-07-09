// Last updated: 09/07/2026, 10:06:49
class Solution {
    public int maxTurbulenceSize(int[] arr) {

        int n = arr.length;

        if (n == 1)
            return 1;

        int left = 0;
        int ans = 1;

        for (int right = 1; right < n; right++) {

            int cmp = Integer.compare(arr[right - 1], arr[right]);

            if (cmp == 0) {
                left = right;
            } else if (right == n - 1 ||
                    cmp * Integer.compare(arr[right], arr[right + 1]) != -1) {

                ans = Math.max(ans, right - left + 1);
                left = right;
            }
        }

        return ans;
    }
}