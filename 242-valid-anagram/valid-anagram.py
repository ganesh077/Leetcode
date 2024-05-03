class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        s = list(s)
        t = list(t)

        if len(s) != len(t):
            return False

        for i in s:
            if i in t:
                t.remove(i)
    
        if t:
            return False
        return True
        