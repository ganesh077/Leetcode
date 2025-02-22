class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> mynew = new ArrayList<List<Integer>>();
        ArrayList<Integer> curr = new ArrayList<Integer>();
        curr.add(1);
        mynew.add(curr);
        for (int i=1; i<numRows; i++) {
            ArrayList<Integer> prev = curr;
            curr = new ArrayList<Integer>();
            curr.add(1);
            for (int j=1; j<i; j++) {
                curr.add(prev.get(j-1)+prev.get(j));
            }
            curr.add(1);
            mynew.add(curr);

        }

        return mynew;
}
}