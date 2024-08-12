class Solution:
    def plusOne(self, digits: List[int]) -> List[int]:
        n = len(digits)

        for i in range(n):
            index = n - 1 - i
            if digits[index] == 9:
                digits[index] = 0
            else:
                digits[index] = digits[index] + 1
                return digits
        
        digits.insert(0,1)
        return digits       



            
                




        