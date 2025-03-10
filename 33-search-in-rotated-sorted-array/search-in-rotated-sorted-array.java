class Solution {
    public int search(int[] arr, int target) {
        if (arr.length == 0) {
            return -1;
        }
        int left = 0;
        int right = arr.length-1;

        while(left <= right) {
            int mid = left + (right - left)/2;

            if(arr[mid] == target) {
                return mid;
            }
            
            if(arr[mid] >= arr[left]) {
                if (arr[left] <= target && arr[mid] > target) {
                    right = mid - 1;
                }
                else {
                left = mid + 1;
                 }
            }

            else {
                if (arr[mid] < target && arr[right] >= target) {
                    left = mid + 1;
                }
                else {
                right = mid - 1;
                 }
            }
        }

        return -1;
    }

}