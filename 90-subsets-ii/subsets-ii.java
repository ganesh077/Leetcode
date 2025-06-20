class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        generate(nums,res,new ArrayList(),0);
        return res;
    }

    public void generate(int[] nums,List<List<Integer>> res, List<Integer> curr, int idx) {
        res.add(new ArrayList(curr));

        for(int i=idx; i<nums.length; i++) {
            if(i > idx && nums[i] == nums[i-1]) {
                continue;
            }
            curr.add(nums[i]);
            generate(nums,res,curr,i+1);
            curr.remove(curr.size()-1);
        }
    }
}