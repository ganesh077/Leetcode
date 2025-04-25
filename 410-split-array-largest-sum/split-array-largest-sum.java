class Solution {
    public int splitArray(int[] nums, int k) {
        int left=0, right=0, result=0;
        for(int i:nums) {
            left = Math.max(left,i);
            right += i;
        }
       
        while (left <= right) {
            int mid = left + (right - left)/2;

            if(ValidSum(nums,k,mid)) {
                result = mid;
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return result;
    }

    public boolean ValidSum(int[] nums,int k,int mid) {
        int placed = 1;
        int sum = 0;

        for(int i=0; i<nums.length; i++) {
            if(sum + nums[i] > mid) {
                placed++;
                sum = nums[i];
            }
            else {
                sum += nums[i];
            }  
            if(placed > k) {
                return false;
            }
        }

        return placed <= k;
    }
}