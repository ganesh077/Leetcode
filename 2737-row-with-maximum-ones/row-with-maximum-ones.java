class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int curr_sum = 0;
        int max = 0;
        int row = 0;
        for(int i=0; i<mat.length; i++) {
            for(int j=0; j<mat[0].length; j++) {
                curr_sum += mat[i][j];
            }
            if (curr_sum > max) {
                max = curr_sum;
                row = i;
                
                System.out.println(row);  
            }
            curr_sum = 0;
        
        }

        return new int[]{row,max};
        
    }
}