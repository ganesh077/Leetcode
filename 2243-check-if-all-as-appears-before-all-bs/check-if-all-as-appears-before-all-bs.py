class Solution:
    def checkString(self, s: str) -> bool:
        flag = 0
        for i in s:
            if i == 'b':
                flag = 1
            if i == 'a' and flag == 1:
                return False
        return True
        