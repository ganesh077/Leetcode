class Solution {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int max = findmax(nums);

        for(int i=0; i<max; i++) {
            if(nums[i] != i) {
                return i;
            }
        }
        return max;
    }

    static int findmax(int[] nums) {
        int max = -1;
        for(int i:nums) {
            if(i > max) {
                max = i;
            } 
        }

        return max+1;
    }
}