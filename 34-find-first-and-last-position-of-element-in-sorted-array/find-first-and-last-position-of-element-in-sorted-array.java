class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = binary(nums,target,false);
        if (left == nums.length || nums[left] != target) {
            return new int[]{-1,-1};
        }
        int right = binary(nums,target,true);
        return new int[]{left,right};      
    }

    public int binary(int[] nums, int target,boolean flag) {
        int low=0, high=nums.length-1, ans = 0;

        while (low<=high) {
            int mid = low + (high-low)/2;
            if (nums[mid] == target) {
                ans = mid;
                if(flag) {
                    low = mid + 1;
                }
                else {
                    high = mid - 1;
                }
            }
            else if (nums[mid] < target) {
                low = mid+1;
            }
            else {
                high = mid-1;
            }
        }

        return ans;
    }
}