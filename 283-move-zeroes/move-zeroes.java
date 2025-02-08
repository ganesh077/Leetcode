class Solution {
    public void moveZeroes(int[] nums) {
        int k = 0;
        for(int i=0; i<nums.length; i++) {
            if (nums[i] != 0) {
                k++;
                nums[k-1] = nums[i];
            }
        }

        while (k<nums.length) {
            nums[k] = 0;
            k++;
        }
        System.out.print(Arrays.toString(nums));
    }
}