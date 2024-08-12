class Solution:
    def reverseWords(self, s: str) -> str:
        s = s.strip()
        temp = s.split()
        return ' '.join(temp[::-1])
        