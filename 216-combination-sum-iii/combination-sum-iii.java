class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        generate(res, new ArrayList(),1,k,n,0);
        return res;
    }

    public void generate(List<List<Integer>> res, List<Integer> current, int start, int k, int n,int currsum) {

        if(current.size() == k) {
            if(currsum == n) {
                res.add(new ArrayList(current));
            }

            return;
        }

        for(int i=start; i<=9; i++) {
            current.add(i);
            generate(res, current,i+1,k,n,currsum+i);
            current.remove(current.size()-1);
        }
        
    }
}