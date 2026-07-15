# Last updated: 15/07/2026, 15:01:32
1class Solution:
2    def divide(self, dividend: int, divisor: int) -> int:
3        INT_MAX = 2**31 - 1
4        INT_MIN = -2**31
5
6        # Handle overflow
7        if dividend == INT_MIN and divisor == -1:
8            return INT_MAX
9
10        # Determine the sign
11        negative = (dividend < 0) != (divisor < 0)
12
13        # Work with positive values
14        dividend = abs(dividend)
15        divisor = abs(divisor)
16
17        quotient = 0
18
19        while dividend >= divisor:
20            temp = divisor
21            multiple = 1
22
23            # Double the divisor until it exceeds dividend
24            while dividend >= (temp << 1):
25                temp <<= 1
26                multiple <<= 1
27
28            dividend -= temp
29            quotient += multiple
30
31        return -quotient if negative else quotient