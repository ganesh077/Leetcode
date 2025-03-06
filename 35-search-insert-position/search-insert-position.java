class Solution {
    public int searchInsert(int[] nums, int target) {
        int low=0, high=nums.length-1, ans=nums.length;

        while (low <= high) {
            int mid = low + (high - low)/2;

            if(nums[mid] == target) {
                ans = mid;
                return ans;
                
            }
            else if (nums[mid] < target) {
                ans = mid+1;
                low = mid+1;
            }
            else {
                high = mid-1;
            }
        }

        return (nums[0] > target)? 0:ans;
    }
}