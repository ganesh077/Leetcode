class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int len = nums.length;
        int total = 1 << len;
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        for(int mask=0; mask<total; mask++) {
            List<Integer> curr = new ArrayList<Integer>();

            for(int i=0; i<len; i++) {
                if((mask & (1 << i)) != 0) {
                    curr.add(nums[i]);
                }
            }

            res.add(curr);

        }

        return res;
    }

}
