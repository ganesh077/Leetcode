class Solution {
    public void nextPermutation(int[] nums) {
        int pivot = -1;

        for (int i=nums.length-1; i>0; i--) {
            if (nums[i] > nums[i-1]) {
                pivot = i-1;
                break;
            }
        }

        if (pivot < 0) {
            reverse(nums,pivot+1,nums.length-1);
            return;
        }
        
        int min = pivot+1;
        for (int i=pivot+1; i<nums.length; i++) {
            if (nums[i] > nums[pivot]) {
                if (nums[min] >= nums[i]) {
                    min = i;
                }
            }
        }

        int temp = nums[min];
        nums[min] = nums[pivot];
        nums[pivot] = temp;

        reverse(nums,pivot+1,nums.length-1);

        System.out.println(Arrays.toString(nums));
    }

    public void reverse(int[] arr, int first, int last) {
        while (first <= last) {
            int temp = arr[first];
            arr[first] = arr[last];
            arr[last] = temp;
            first++;
            last--;
        }
    }
}