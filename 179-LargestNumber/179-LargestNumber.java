// Last updated: 09/07/2026, 10:07:13
import java.util.*;

class Solution {
    public String largestNumber(int[] nums) {
        
        String[] arr = new String[nums.length];
        
        // Convert integers to strings
        for (int i = 0; i < nums.length; i++) {
            arr[i] = String.valueOf(nums[i]);
        }
        
        // Sort based on which combination forms a larger number
        Arrays.sort(arr, (a, b) -> (b + a).compareTo(a + b));
        
        // Edge case: if all numbers are 0
        if (arr[0].equals("0")) {
            return "0";
        }
        
        StringBuilder result = new StringBuilder();
        
        for (String s : arr) {
            result.append(s);
        }
        
        return result.toString();
    }
}