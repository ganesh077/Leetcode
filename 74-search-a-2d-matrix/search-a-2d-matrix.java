class Solution {
    public boolean binary(int[][] matrix,int row, int target) {
        int left = 0;
        int right = matrix[0].length-1;

        while(left <= right) {
            int mid = left + (right - left)/2;

            if(matrix[row][mid] == target) {
                return true;
            }
            else if (matrix[row][mid] > target) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        
        }

        return false;
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        int left = 0;
        int right = matrix.length-1;
        int row = -1;

        while(left <= right) {
            int mid = left + (right - left)/2;
            System.out.println(matrix[mid][matrix[0].length-1]+" "+target);

            if( matrix[mid][matrix[0].length-1] >= target) {
                row = mid;
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }

        if(row < 0) {
            System.out.print(row);
            return false;
        }

        return binary(matrix,row,target);
    }
}