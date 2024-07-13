class Solution:
    def judgeCircle(self, moves: str) -> bool:
        x,y = 0,0

        for i in moves:
            if i == 'R':
                x += 1
            elif i == 'L':
                x -= 1
            elif i == 'U':
                y += 1
            else:
                y -= 1
        
        return x == 0 and y == 0
        