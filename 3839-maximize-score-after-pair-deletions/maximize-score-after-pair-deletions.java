class Solution {
    public int maxScore(int[] nums) {
        int n = nums.length;
        int total = 0;
        for(int num: nums) total += num;

        if(n % 2 != 0) {
            int currMin = Integer.MAX_VALUE;
            for(int num: nums) {
                currMin = Math.min(currMin, num);
            }
            return total - currMin;
        }  
        else {
             int pair = Integer.MAX_VALUE;
             for(int i=0; i<n-1; i++) {
                int sum = nums[i] + nums[i+1];
                pair = Math.min(pair, sum);
             }
             return total - pair;
        }
    }

}