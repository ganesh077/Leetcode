class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> current = new ArrayList<Integer>();
        generate(result,0,nums,current);
        return result;
    }

    public void generate(List<List<Integer>> result, int idx, int[] nums, List<Integer> current) {
        List<Integer> snapshot = new ArrayList<>(current);
        result.add(snapshot);
        for(int i=idx; i<nums.length; i++) {
            current.add(nums[i]);
            generate(result, i+1, nums, current);
            current.remove(current.size()-1);
        }

    }


}
