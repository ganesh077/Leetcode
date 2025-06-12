class NumMatrix {
    private int[][] prefix;   
    
    public NumMatrix(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return;
        prefix = new int[matrix.length][matrix[0].length+1];

        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[0].length; j++) {
                prefix[i][j+1] = prefix[i][j] + matrix[i][j];
            }
        }

        
        
    }
    
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for(int i=row1; i<=row2; i++) {
            sum += prefix[i][col2+1] - prefix[i][col1];
        }

        return sum;
}
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */