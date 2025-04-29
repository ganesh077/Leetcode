
class Solution {
    public double minmaxGasDist(int[] stations, int k) {
        double left = 0, right = 1e8;


        while(right - left > 1e-6) {
            double mid = left + (right - left)/2;

            if(canReduce(stations, k, mid)) {
                right = mid;
            }
            else {
                left = mid;
            }
        }

        return right;
    }

        public boolean canReduce(int[] stations, int k, double mid) {
            int placed = 0;
            double gap = 0;
            
            for(int i = 1; i < stations.length; i++) {
                gap = stations[i] - stations[i-1];
                placed += Math.ceil(gap/mid) - 1;
            }

            return placed <= k;
        }
    
}
