class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int curr_row = 0;
        while(curr_row < matrix.length) {
            int left = 0;
            int right = matrix[0].length-1;
            if(target >= matrix[curr_row][0] && target <= matrix[curr_row][matrix[0].length-1]) {
                while(left <= right) {

                int mid = left + (right - left)/2;

                if(matrix[curr_row][mid] == target) {
                return true;
                }
                else if(matrix[curr_row][mid] < target) {
                    left = mid + 1;
                }
                else {
                    right = mid - 1;
                }

                }
                
            }
            curr_row++; 
        }

        return false;

        
    }
}