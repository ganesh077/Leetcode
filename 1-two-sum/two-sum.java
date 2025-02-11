class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> mymap = new HashMap<Integer, Integer>();
        int[] res = new int[2];

        for (int i=0; i<nums.length; i++) {
            if (mymap.containsKey(target-nums[i])) {
                res[0] = i;
                res[1] = mymap.get(target-nums[i]);
            }
            mymap.put(nums[i],i);
        }

        return res;
    }
}