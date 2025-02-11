class Solution {
    public int majorityElement(int[] nums) {
        int current = nums[0];
        int count = 0;

        for (int i:nums) {
            if ( count == 0) {
                current = i;
            }

            count += (i == current) ? -1 : 1;
        }
        return current;
    }
}