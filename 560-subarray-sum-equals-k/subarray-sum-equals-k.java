class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> prefix = new HashMap<Integer,Integer>();

        if (nums.length == 1) {
            if (nums[0] == k) {
                return 1;
            }
            else {
                return 0;
            }
        }
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

        System.out.print(Arrays.toString(prefix.entrySet().toArray()));

        return count;
        
    }
}