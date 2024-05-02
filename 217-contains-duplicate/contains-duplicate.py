class Solution:
    def containsDuplicate(self, nums: List[int]) -> bool:
        s = {}
        for i in nums:
            if i not in s:
                s[i] = 1
            else:
                return True
        return False
        
        