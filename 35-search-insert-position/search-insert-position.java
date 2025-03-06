class Solution {
    public int searchInsert(int[] nums, int target) {
        for(int i=0; i<nums.length; i++) {
            if (nums[i] >= target) {
                if(i==0) {
                    return 0;
                }
                return i;
            }
        }
        return nums.length;
    }
}