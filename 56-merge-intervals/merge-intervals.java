class Solution {
    public int[][] merge(int[][] intervals) {

        if (intervals.length <= 1) {
            return intervals;
        }

        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0]));

        ArrayList<int[]> merged = new ArrayList<int[]>();

        for (int[] interval: intervals) {
            if (merged.size() == 0 || merged.get(merged.size()-1)[1] < interval[0]) {
                merged.add(interval);
            }
            else {
                merged.get(merged.size()-1)[1] = Math.max(merged.get(merged.size()-1)[1],interval[1]);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }
}