class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int maxcount = 0;
        int currcount = 0;
        int max = nums[0];
        for( int i=0; i<nums.length-1; i++) {
            if (nums[i] == nums[i+1]) {
                currcount++;
                if (currcount > maxcount) {
                    maxcount = currcount;
                    max = nums[i];
                }
            }
            else {
                currcount = 0;
            }
        }

        return max;
    }
}