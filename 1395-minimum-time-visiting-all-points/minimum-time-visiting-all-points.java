class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int cost = 0;
        int[] curr = points[0];
        for(int[] point: points) {
            cost += Math.max(Math.abs(curr[0] - point[0]), Math.abs(curr[1] - point[1]));
            curr = point;
        }

        return cost;
    }
}