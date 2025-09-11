class Solution {
    public long largestEvenSum(int[] nums, int k) {
        int n = nums.length; 
        if(k > n || k < 1) return -1;
        

        Arrays.sort(nums);
        long sum = 0;
        for(int i=n-k; i<n; i++) {
            sum += nums[i];
        }

        if(sum%2 == 0) return sum;
        else {
            int maxEven = -1, maxOdd = -1;
            int minkEven = -1, minKOdd = -1;
            for(int i=0; i<n-k; i++) {
                if(nums[i]%2 == 0) {
                    maxEven = nums[i];
                }
                else {
                    maxOdd = nums[i];
                }
            }

            for(int i=n-1; i>=n-k; i--) {
                if(nums[i]%2 == 0) {
                    minkEven = nums[i];
                }
                else {
                    minKOdd = nums[i];
                }
            }

            long best = -1;
            if (maxOdd != -1 && minkEven != -1) best = Math.max(best, (sum - minkEven + maxOdd));
            
            if (maxEven != -1 && minKOdd != -1) best = Math.max(best, (sum - minKOdd + maxEven));

            return best;

        }
        
    }
}