class Solution {
    public int singleNonDuplicate(int[] nums) {
        int left = 0;
        int right = nums.length-1;

        if(nums.length == 1) {
            return nums[0];
        }

        while (left < right) {
            System.out.println(left+" "+right);
            int mid = left + (right - left)/2;
            if(mid == 0) {
                return nums[mid];
            }
            if(mid == nums.length-1) {
                return nums[mid];
            }
            if(nums[mid] == nums[mid+1]) {
                if(mid%2==0) {
                    left = mid+2;
                }
                else {
                    right = mid-1;
                }
            }
            else if (nums[mid] == nums[mid-1]) {
                if(mid%2!=0) {
                    left = mid+1;
                }
                else {
                    right = mid-2;
                }
            }
            else {
                return nums[mid];
            }
        }

        return nums[left];
    }
}