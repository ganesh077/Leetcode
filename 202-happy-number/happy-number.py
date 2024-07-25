class Solution:
    def sumsquares(self,n):
        sum = 0
        temp = n
        while temp:
            val = temp%10
            sum += val**2
            temp = temp // 10
        return sum

    def isHappy(self, n: int) -> bool:
        seen = set()
        seen.add(n)
        while True:
            if self.sumsquares(n) == 1:
                return True
            n = self.sumsquares(n)
            if n in seen:
                return False
            else:
                seen.add(n)
            

        
        