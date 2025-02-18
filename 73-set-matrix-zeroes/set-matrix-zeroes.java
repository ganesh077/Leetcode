class Solution {
    public void setZeroes(int[][] matrix) {
        ArrayList<int[]> indexes = new ArrayList<>();
        for (int row=0; row<matrix.length; row++) {
            for (int col=0; col<matrix[row].length; col++) {
                if (matrix[row][col] == 0) {
                    indexes.add(new int[]{row,col});
                    }
                }
            }
        for (int[] num: indexes) {
            int row = num[0];
            int col = num[1];
            while (row < matrix.length) {
                matrix[row][col] = 0;
                row++;
            }
            row = num[0];
            while (row >= 0) {
                matrix[row][col] = 0;
                row--;
            }
            row = num[0];
            while (col < matrix[row].length) {
                matrix[row][col] = 0;
                col++;
            }
            col = num[1];
            while (col >= 0) {
                matrix[row][col] = 0;
                col--;
            }
        }
        }  
    }