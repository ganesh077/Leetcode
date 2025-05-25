class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int left = 0;
        int right = matrix[0].length-1;
        int curr = matrix[left][right];
    

        while(left < matrix.length && right >= 0) {
            curr = matrix[left][right];
            
            if(curr == target) {
                return true;
            }
            else if(curr < target) {
                left++;
            }
            else {
                right--;
            }
        }

        if(curr == target) {
            return true;
        }
        return false;

        
    }
}