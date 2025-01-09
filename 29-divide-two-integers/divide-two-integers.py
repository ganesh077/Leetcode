class Solution:
    def divide(self, dividend: int, divisor: int) -> int:
        INT_MAX, INT_MIN = 2**31-1, -2**31

        if divisor == -1 and dividend == INT_MIN:
            return INT_MAX

        quo = 0

        neg = (divisor < 0) != (dividend < 0)

        dividend, divisor = abs(dividend), abs(divisor)

        

        for i in range(31,-1,-1):
            if dividend >= (divisor << i):
                dividend -= (divisor << i)
                quo += (1 << i)
        
        return -quo if neg else quo
        
         


        