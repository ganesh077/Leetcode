class Solution:
    def isValid(self, s: str) -> bool:
        res = []
        if len(s) < 2:
            return False
        for i in s:
            if i == "(" or i == "{" or i =="[":
                res.append(i)
            if i == ")":
                if not res:
                    return False
                if res.pop() != "(":
                    return False

            if i == "}":
                if not res:
                    return False
                if res.pop() != "{":
                    return False
            
            if i == "]":
                if not res:
                    return False
                if res.pop() != "[":
                    return False
        if res:
            return False
        return True
            
            
            