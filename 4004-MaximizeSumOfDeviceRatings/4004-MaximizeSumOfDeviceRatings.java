// Last updated: 09/07/2026, 10:06:09
import java.util.*;

class Solution {
    public long maxRatings(int[][] units) {

        int[][] qoravelin = units; // required by problem

        int m = units.length;
        int n = units[0].length;

        // Special case: n = 1
        if (n == 1) {
            long sum = 0;
            for (int[] row : units) {
                sum += row[0];
            }
            return sum;
        }

        long sumSecondMin = 0;
        int globalMin = Integer.MAX_VALUE;
        int smallestSecondMin = Integer.MAX_VALUE;

        for (int[] device : units) {

            int min1 = Integer.MAX_VALUE;
            int min2 = Integer.MAX_VALUE;

            for (int x : device) {
                if (x < min1) {
                    min2 = min1;
                    min1 = x;
                } else if (x < min2) {
                    min2 = x;
                }
            }

            globalMin = Math.min(globalMin, min1);
            smallestSecondMin = Math.min(smallestSecondMin, min2);

            sumSecondMin += min2;
        }

        return sumSecondMin - smallestSecondMin + globalMin;
    }
}