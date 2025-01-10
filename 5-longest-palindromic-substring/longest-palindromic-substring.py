class Solution:
    def ispalin(self,s,left,right):
        n = len(s)

        while left >= 0 and right < n:
            if s[left] != s[right]:
                break
            left -=1
            right += 1

        return s[left+1:right]

        

    def longestPalindrome(self, s: str) -> str:
        res = ''
        max_palin = 0

        for i in range(len(s)):
            odd_palin = self.ispalin(s,i,i)
            if odd_palin:
                if len(odd_palin) > max_palin:
                    max_palin = len(odd_palin)
                    res = odd_palin
            
            even_palin = self.ispalin(s,i,i+1)
            if even_palin:
                if len(even_palin) > max_palin:
                    max_palin = len(even_palin)
                    res = even_palin
        return res
                    

        


        