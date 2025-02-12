class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int curr = nums[0];
        for( int i=1; i < nums.length; i++) {
            curr = Math.max(nums[i], curr+nums[i]);
            max = Math.max(curr,max);
            }
        
        return max;

    }
}