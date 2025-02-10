class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maximum = 0;
        int currcount = 0;
        for (int i:nums) {
            if (i == 1) {
                currcount++;
            }
            else {
                maximum = Math.max(maximum,currcount);
                currcount = 0;
            }
        }
        return  Math.max(maximum,currcount);
    }
}