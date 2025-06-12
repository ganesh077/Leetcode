class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] left = new int[len];
        int[] right = new int[len];
        int[] res = new int[len];
        left[0] = nums[0];
        right[len-1] = nums[len-1];
        for(int i=1; i<len; i++) {
            left[i] = left[i-1]*nums[i];
        }
        for(int i=len-2; i>=0; i--) {
            right[i] = right[i+1]*nums[i];
        }

        for(int i=0; i<len; i++) {
            if(i == 0) {
                res[i] = right[i+1];
                continue;
            }
            if(i == len-1 ) {
                res[i] = left[i-1];
                continue;
            }
            res[i] = left[i-1]*right[i+1];
        }

        return res;

    }
}