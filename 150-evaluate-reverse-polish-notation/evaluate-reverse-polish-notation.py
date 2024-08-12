class Solution:
    def operations(self,num1,num2,op):
        num1 = int(num1)
        num2 = int(num2)
        if op == "+":
            return num1 + num2
        elif op == "*":
            return num1 * num2
        elif op == "/":
            return int(num1 / num2)
        elif op == "-":
            return num1 - num2

    def evalRPN(self, tokens: List[str]) -> int:
        if len(tokens) == 1:
            return int(tokens[0]) 
        operators = ['+','-','*','/']
        first_tk, second_tk = 0,1
        stk = [tokens[first_tk],tokens[second_tk]]
        i = 2
        while i < len(tokens):
            if tokens[i] in operators:
                exp = self.operations(stk[first_tk],stk[second_tk],tokens[i])
                stk.pop()
                stk.pop()
                first_tk -= 1
                second_tk -= 1
                stk.append(exp) 
                i += 1
            else:
                first_tk += 1
                second_tk += 1
                stk.append(tokens[i])
                i += 1
        return stk[-1]


        