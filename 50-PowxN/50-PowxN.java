// Last updated: 09/07/2026, 10:07:37
class Solution {
    public double myPow(double x, int n) {
        long N = n; // handle Integer.MIN_VALUE

        if (N < 0) {
            x = 1 / x;
            N = -N;
        }

        double result = 1.0;

        while (N > 0) {
            if ((N & 1) == 1) { // odd exponent
                result *= x;
            }

            x *= x;
            N /= 2;
        }

        return result;
    }
}