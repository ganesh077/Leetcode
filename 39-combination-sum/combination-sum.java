class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        generateCombo(candidates,target,0,0,result,new ArrayList());
        return result;
    }

    public void generateCombo(int[] candidates, int target,int currsum, int idx, List<List<Integer>> result,List<Integer> current) {
         if (currsum > target) {
            return;
        }
        if(idx == candidates.length) {
            if(currsum == target) {
                result.add(new ArrayList(current));
            }

            return;
        }

        generateCombo(candidates, target,currsum, idx+1, result, current);

        currsum += candidates[idx];
        current.add(candidates[idx]);

        generateCombo(candidates, target,currsum, idx, result, current);

        currsum -= candidates[idx];
        current.remove(current.size()-1);


    }
}