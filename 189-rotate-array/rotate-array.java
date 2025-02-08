class Solution {
    public void rotate(int[] nums, int k) {
        int[] temparr = new int[nums.length];
        for(int i=0; i<nums.length; i++) {
            int l = (i+k)%nums.length;    
            temparr[l] = nums[i] ;
        }
        System.out.print(Arrays.toString(temparr));
        System.arraycopy(temparr, 0, nums, 0, nums.length);
    }
}