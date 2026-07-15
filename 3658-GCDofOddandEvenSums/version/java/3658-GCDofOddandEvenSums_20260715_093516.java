// Last updated: 15/07/2026, 09:35:16
1class Solution {
2
3    public int gcdOfOddEvenSums(int n) {
4
5        int sumOdd = n * n;
6        int sumEven = n * (n + 1);
7
8        return gcd(sumOdd, sumEven);
9    }
10
11    private int gcd(int a, int b) {
12        while (b != 0) {
13            int temp = b;
14            b = a % b;
15            a = temp;
16        }
17        return a;
18    }
19}