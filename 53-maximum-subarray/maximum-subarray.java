class Solution {
    public int maxSubArray(int[] nums) {
        return maxSubArrayHelper(nums, 0,nums.length-1);
    }

    public int maxSubArrayHelper(int[] nums, int left,int right) {
        int mid = left+(right-left)/2;

        if (left == right) {
            return nums[right];
        }

        int leftmax = maxSubArrayHelper(nums,left,mid);
        int rightmax = maxSubArrayHelper(nums,mid+1,right);
        int crossmax =maxCrossSubArray(nums,left,mid,right);

        return Math.max(Math.max(leftmax,rightmax),crossmax);
    }

    public int maxCrossSubArray(int[] nums,int left,int mid,int right) {
        int sum = 0;
        int leftsum = Integer.MIN_VALUE;
        int temp = mid;
        while (temp >= left) {
            sum += nums[temp];
            leftsum = Math.max(leftsum,sum);
            temp--;
        }
        int rightsum = Integer.MIN_VALUE;
        sum = 0;
        mid++;
        while (mid <= right) {
            sum += nums[mid];
            rightsum = Math.max(rightsum,sum);
            mid++;
        }

        return leftsum+rightsum;
    }
}