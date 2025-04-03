class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int left = 1;
        int right = max(nums);
        int ans = 1;

        while (left <= right) {
            int mid = left + (right - left)/2;


            if(threshold(nums,mid,threshold)) {
                ans = mid;
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }

        return ans;
        
    }

    public int min(int[] nums) {
        int min = nums[0];
        for(int num:nums) {
            min = Math.min(num,min);
        }
        return min;
    }

    public int max(int[] nums) {
        int max = nums[0];
        for(int num:nums) {
            max = Math.max(num,max);
        }
        return max;
    }

    public boolean threshold(int[] nums,int divisor,int threshold) {
        int sum = 0;

        for(int num: nums) {
            sum += (num+divisor-1)/divisor;
        }
        if(sum <= threshold) {
            return true;
        }
        return false;
    }
}