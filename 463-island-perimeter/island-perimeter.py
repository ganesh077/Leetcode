class Solution:
    def islandPerimeter(self, grid: List[List[int]]) -> int:
    
        rows = len(grid)
        cols = len(grid[0])
        per = 0
        

        for i in range(rows):
            for j in range(cols):
                if grid[i][j] == 1:
                    if i == 0:
                        up = 0
                    else:
                        up = grid[i-1][j]
                    if j == 0:
                        left = 0
                    else:
                        left = grid[i][j-1]
                    if i == len(grid) - 1:
                        down = 0
                    else:
                        down = grid[i+1][j]
                    if j == len(grid[0]) - 1:
                        right = 0
                    else:
                        right = grid[i][j+1]
                    per += 4 - (left + right + down + up)


        return per