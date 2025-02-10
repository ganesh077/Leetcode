class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int expectedsum = (n*(n+1))/2;
        int realsum = 0;
        for (int i: nums) {
            realsum += i;
        }

        return expectedsum - realsum;
    }
}