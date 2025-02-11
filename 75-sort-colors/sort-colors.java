class Solution {
    public void sortColors(int[] nums) {
        int low = 0;
        int move = 0;
        int high = nums.length-1;
        while (move <= high) {
            if (nums[move] == 0) {
                int temp = nums[low];
                nums[low] = nums[move];
                nums[move] = temp;
                low++;
                move++;
            }

            else if (nums[move] == 1) {
                move++;
            }
            else {
                int temp = nums[high];
                nums[high] = nums[move];
                nums[move] = temp;
                high--;
            }
        }
        

        //System.arraycopy(nums,0,nums,0,nums.length);
    }
}