// Last updated: 09/07/2026, 10:07:22
class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();

        while (columnNumber > 0) {
            columnNumber--; // adjust for 1-based indexing

            int rem = columnNumber % 26;
            sb.append((char) ('A' + rem));

            columnNumber /= 26;
        }

        return sb.reverse().toString();
    }
}