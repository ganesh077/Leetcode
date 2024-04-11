class Solution:
    def removeKdigits(self, num: str, k: int) -> str:
        stack = []

        if len(num) == k:
            return "0"

        for digit in num:
            while k > 0 and stack and stack[-1] > digit:
                stack.pop()
                k -= 1
            stack.append(digit)

        # If there are still more digits to remove
        while k > 0:
            stack.pop()
            k -= 1

        # Remove leading zeros
        while stack and stack[0] == '0':
            stack.pop(0)

        return ''.join(stack) if stack else "0"
