class Solution:
    def transpose(self, matrix: List[List[int]]):
        for i in range(len(matrix[0])):
            for j in range(i+1,len(matrix[0])):
                matrix[i][j], matrix[j][i] = matrix[j][i], matrix[i][j]
    
    def reverse(self, matrix: List[List[int]]):
        
        for i in range(len(matrix)):
            end = len(matrix[0]) - 1
            front = 0
            while front < end:
                matrix[i][front],matrix[i][end] = matrix[i][end],matrix[i][front]
                front += 1
                end -= 1
            
                

            
            
    def rotate(self, matrix: List[List[int]]) -> None:
        """
        Do not return anything, modify matrix in-place instead.
        """
        self.transpose(matrix)
        self.reverse(matrix)
