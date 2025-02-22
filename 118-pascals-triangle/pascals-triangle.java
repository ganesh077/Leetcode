class Solution {
    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> result = new ArrayList<List<Integer>>();

        for (int i=0; i<numRows; i++) {
            ArrayList<Integer> val = new ArrayList<Integer>();
            int value = 1;
            val.add(value);
            for (int j=1; j<=i; j++) {
                value = value * (i-j+1)/j;
                val.add(value);  
            }
            result.add(val);
            
        }
       return result;
    }
}