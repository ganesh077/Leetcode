import java.util.List;

class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            int val = nums.get(i);
            
            if (val == 2) {
                ans[i] = -1;
            } else {
                int nextVal = val + 1;
                // Find the lowest set bit and shift it right by 1
                // This identifies the largest bit in the trailing streak of 1s
                int subtractVal = Integer.lowestOneBit(nextVal) >> 1;
                ans[i] = val - subtractVal;
            }
        }
        
        return ans;
    }
}