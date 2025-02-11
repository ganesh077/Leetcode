class Solution {
    public void sortColors(int[] nums) {
        int k = 0;
        for (int i=0; i<nums.length; i++) {
            if (nums[i] == 0) {
                int temp = nums[k];
                nums[k] = nums[i];
                nums[i] = temp;
                k++;
            }
            
        }
        k = nums.length-1;
        for (int i=nums.length-1; i>=0; i--) {
            if (nums[i]==2) {
                int temp = nums[k];
                nums[k] = nums[i];
                nums[i] = temp;
                k--;
            }
            
        }
        //System.arraycopy(nums,0,nums,0,nums.length);
    }
}