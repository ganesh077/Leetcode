class Solution:
    def plusOne(self, digits: List[int]) -> List[int]:
        if len(digits) < 1:
            return []
        if digits[-1] != 9:
            digits[-1] = digits[-1] + 1
            return digits
        else:
            n = -1
            while n >= -len(digits) and digits[n] == 9:
                digits[n] = 0
                n -= 1
            if -n > len(digits):
                digits.insert(n,1)
            else:
                digits[n] = digits[n] + 1
        return digits
                    



            
                




        