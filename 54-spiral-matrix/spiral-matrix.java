class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int i = 0;
        int j = -1;
        int direction = 1;
        int col = matrix[0].length;
        int row = matrix.length;

        ArrayList<Integer> result = new ArrayList<Integer>();

        while (row*col > 0) {
            for (int k=0; k < col; k++) {
                j += direction;
                result.add(matrix[i][j]);
            }
            row -= 1;
            for (int k=0; k < row; k++) {
                i += direction;
                result.add(matrix[i][j]);
            }
            col -= 1;

            direction *= -1;
        }
        return result;
        }


        

        
    }