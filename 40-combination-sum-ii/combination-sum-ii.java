class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        genCombo(result,candidates,target,0,0,new ArrayList());
        return result;
    }

    public void genCombo(List<List<Integer>> result, int[] candidates, int target, int currsum, int idx, List<Integer> current) {
        if(currsum > target) {
            return;
        }
        if(currsum == target) {
            result.add(new ArrayList(current));
            return;
        }

        for(int i=idx; i<candidates.length; i++) {

            if (i > idx && candidates[i] == candidates[i - 1]) {
                continue;
            }
            current.add(candidates[i]);
            genCombo(result, candidates, target, currsum + candidates[i], i + 1, current);
            current.remove(current.size()-1);
        }
        
    }
}