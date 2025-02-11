class Solution {
    public int majorityElement(int[] nums) {
        int current = nums[0];
        int count = 0;

        for (int i:nums) {
            if ( i == current) {
                count++;
            }
            else {
                 count--;
            }
            
            if ( count == 0) {
                current = i;
                count++;
            }
            

        }
        return current;
    }
}