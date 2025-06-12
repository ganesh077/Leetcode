class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int ans[] = new int[len];

        int left = 1;
        for(int i=0; i<len; i++) {
            ans[i] = left;
            left *= nums[i];
        }

        int right = 1;
        for(int i=len-1; i>=0; i--) {
            ans[i] *= right;
            right *= nums[i];
        }

        return ans;
    }
}