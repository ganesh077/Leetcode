class Solution {
    public int reversePairs(int[] nums) {
        int[] temp = new int[nums.length];
        int count = mergesort(nums,temp,0,nums.length-1);
        return count;
    }

    public int mergesort(int[] nums, int[] temp, int left, int right) {
        int mid = (left + right)/2;
        int count = 0;
        if ( left >= right) {
            return 0;
        }

        count += mergesort(nums,temp,left,mid);
        count += mergesort(nums,temp,mid+1,right);
        count += mergeandcount(nums,temp,left,mid,right);

        return count;

    }

    public int mergeandcount(int[] nums, int[] temp,int left, int mid, int right) {
        int i = left;
        int j = mid+1;
        int k = left;
        int reversecount = 0;

        int p = left;
        for (int x=mid+1; x<=right; x++) {
            while(p <= mid && nums[p] <= 2l*nums[x]) p++;
            reversecount += (mid-p+1);
        }
        while (i <= mid && j <= right) {
            if (nums[i] < nums[j]) {
                temp[k++] = nums[i++];
            }
            else {
                temp[k++] = nums[j++];   
            }
        }

        while( i <= mid) {
            temp[k++] = nums[i++];
        }

        while( j <= right) {
            temp[k++] = nums[j++];
        }

        for(int l=left; l<=right; l++) {
            nums[l] = temp[l];
        }
        return reversecount;
    }
}