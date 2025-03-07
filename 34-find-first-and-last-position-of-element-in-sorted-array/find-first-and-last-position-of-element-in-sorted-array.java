class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1,-1};
        }

        int[] res = new int[2];
        res[0] = binarystart(nums,target);
        res[1] = binaryend(nums,target);  

        return res;      
    }

    public int binaryend(int[] nums, int target) {
        int low=0, high=nums.length-1, end = -1;

        while (low<=high) {
            int mid = low + (high-low)/2;


            if (nums[mid] == target) {
                end = mid;
                low = mid+1;
            }
            else if (nums[mid] < target) {
                low = mid+1;
            }
            else {
                high = mid-1;
            }
        }

        return end;
    }

    public int binarystart(int[] nums, int target) {
        int low=0, high=nums.length-1, start = -1;

        while (low<=high) {
            int mid = low + (high-low)/2;

            if (nums[mid] == target) {
                 start = mid;
                 high = mid - 1;
            }
            else if (nums[mid] < target) {
                low = mid+1;
            }
            else {
                high = mid-1;
            }
        }

        return start;
    }
}