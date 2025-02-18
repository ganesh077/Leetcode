class Solution {
    public void setZeroes(int[][] matrix) {
            boolean firstrow = false;
            boolean firstcol = false;
            int row_len = matrix.length;
            int col_len = matrix[0].length;


            for (int i=0; i<row_len; i++) {
                if (matrix[i][0] == 0) {
                    firstrow = true;
                    break;
                }
            }

            for (int i=0; i<col_len; i++) {
                if (matrix[0][i] == 0) {
                    firstcol = true;
                    break;
                }
            }

            for (int i=1; i<row_len; i++) {
                for (int j=1; j<col_len; j++) {
                    if (matrix[i][j] == 0) {
                        matrix[i][0] = 0;
                        matrix[0][j] = 0;
                    }
                }
            }

            for (int i=1; i<row_len; i++) {
                for (int j=1; j<col_len; j++) {
                    if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                        matrix[i][j] = 0;
                    }
                }
            }

            if (firstrow) {
                for (int i=0; i<row_len; i++) {
                    matrix[i][0] = 0;
                }

            }

            if (firstcol) {
                for (int i=0; i<col_len; i++) {
                    matrix[0][i] = 0;
                }

            }



        }  
    }