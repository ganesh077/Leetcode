class Solution:
    def divide(self, dividend: int, divisor: int) -> int:
        INT_MAX, INT_MIN = 2147483647, -2147483648

        if dividend == INT_MIN and divisor == -1:
            return INT_MAX
        neg = (dividend < 0) != (divisor < 0)
        quo = 0
        dividend,divisor = abs(dividend),abs(divisor)
        for i in range(31,-1,-1):
            if (divisor << i) <= dividend:
                dividend -= (divisor << i)
                quo += (1 << i)

        return -quo if neg else quo


        