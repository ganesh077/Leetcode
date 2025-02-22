class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> prefix = new HashMap<Integer,Integer>();

        int count = 0;
        int sum = 0;
        prefix.put(0,1);

        for(int i=0; i<nums.length; i++) {
            sum += nums[i];
            if(prefix.containsKey(sum - k)) {
                count += prefix.get(sum-k);
            }
            prefix.put(sum,prefix.getOrDefault(sum,0)+1);
            
        }

        return count;
        
    }
}