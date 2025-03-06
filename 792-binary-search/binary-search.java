class Solution {
    public int search(int[] nums, int target) {
        int result = binarysearch(nums,target);
        return result;
    }

    public int binarysearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        

        while (left <= right) {
            int mid = (left+right)/2;
            if (target > nums[mid]) {
                left = mid+1;
            }
            else if (target == nums[mid]) {
                return mid;
            }
            else {
                right = mid-1;
            }
        }

        return -1;
    }
}