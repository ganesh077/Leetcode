class Solution:
    def addBinary(self, a: str, b: str) -> str:
        n = max(len(a),len(b))
        a,b = a.zfill(n),b.zfill(n)
        res = []
        carry = 0

        for i in range(n-1,-1,-1):
            sum = int(a[i]) + int(b[i]) + carry
            res.append(str(sum%2))
            carry = sum//2
        
        if carry == 1:
            res.append("1")
        res.reverse()

        return ''.join(res)

