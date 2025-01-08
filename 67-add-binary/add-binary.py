class Solution:
    def addBinary(self, a: str, b: str) -> str:
        sum_a,len_a = 0,len(a)-1
        sum_b,len_b = 0,len(b)-1
        res = 0
        for char in a:
            sum_a += int(char) * 2**len_a
            len_a -= 1
        
        for char in b:
            sum_b += int(char) * 2**len_b
            len_b -= 1

        res = sum_a + sum_b

        return bin(res)[2:]
