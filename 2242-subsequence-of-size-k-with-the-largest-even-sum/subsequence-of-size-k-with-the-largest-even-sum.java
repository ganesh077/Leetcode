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
                    if(maxEven == - 1) maxEven = nums[i];
                    else maxEven = Math.max(maxEven, nums[i]);
                }
                else {
                    if(maxOdd == - 1) maxOdd = nums[i];
                    else maxOdd = Math.max(maxOdd, nums[i]);
                }
            }

            for(int i=n-k; i<n; i++) {
                if(nums[i]%2 == 0) {
                    if(minkEven == - 1) minkEven = nums[i];
                    else minkEven = Math.min(minkEven, nums[i]);
                }
                else {
                    if(minKOdd == - 1) minKOdd = nums[i];
                    else minKOdd = Math.min(minKOdd, nums[i]);
                }
            }

            long best = -1;
            best = Math.max(best, (maxOdd == -1 || minkEven == -1)? - 1 : sum - minkEven + maxOdd);
            
            best = Math.max(best, (maxEven == -1 || minKOdd == -1)? - 1 : sum - minKOdd + maxEven);

            return best;

        }
        
    }
}