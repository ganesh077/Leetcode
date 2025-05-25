class Solution {
    
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int cols = matrix[0].length;
        int rows = matrix.length;

        int left = 0;
        int right = (rows*cols)-1;
        

        while(left <= right) {
            int mid = left + (right - left)/2;
            if( matrix[mid/cols][mid%cols] == target) {
                return true;
            }
            else if( matrix[mid/cols][mid%cols] > target) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }

        return false;
    }
}