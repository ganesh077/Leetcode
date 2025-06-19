class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        generateSubsets(nums,result,new ArrayList(),0);
        return result;
    }

    public void generateSubsets(int[] nums,List<List<Integer>> result, List<Integer> current,int index) {
        if(index == nums.length) {
            result.add(new ArrayList(current));
            return;
        } 

        generateSubsets(nums,result,current,index+1);

        current.add(nums[index]);
        generateSubsets(nums,result,current,index+1);
        current.remove(current.size()-1);
    }

}
