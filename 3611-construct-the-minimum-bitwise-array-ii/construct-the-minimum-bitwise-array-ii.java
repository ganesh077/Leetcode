class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int[] ans = new int[nums.size()];
        for(int i=0; i<nums.size(); i++) {
            if(nums.get(i) == 2) {
                ans[i] = -1;
                continue;
            }
            int next = nums.get(i)+1;
            int target = Integer.lowestOneBit(next) >> 1;
            ans[i] = nums.get(i) - target;

        }
        return ans;
    }
}