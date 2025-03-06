class Solution {
    public int maxProduct(int[] nums) {
        int max = nums[0];
        int currmax = nums[0];
        int currmin = nums[0];

        for (int i=1; i<nums.length; i++) {
            if (nums[i] < 0) {
                int tmp = currmax;
                currmax = currmin;
                currmin = tmp;
            }
            currmax = Math.max(nums[i],currmax*nums[i]);
            currmin = Math.min(nums[i],currmin*nums[i]);
            if (currmax > max) {
                max = currmax;
            }
        }

        return max;
    }
}