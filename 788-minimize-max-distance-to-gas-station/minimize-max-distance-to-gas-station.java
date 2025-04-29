
class Solution {
    public double minmaxGasDist(int[] stations, int k) {
        float left = 0, right = 0;

        for(int i=1; i<stations.length; i++) {
            //left = Math.min(left, (stations[i] - stations[i-1]));
            right = Math.max(right, (stations[i] - stations[i-1]));
        }

        for(int i=0; i<40 ; i++) {
            float mid = left + (right - left)/2;

            if(canReduce(stations, k, mid)) {
                right = mid;
            }
            else {
                left = mid;
            }
        }

        return right;
    }

        public boolean canReduce(int[] stations, int k, float mid) {
            int placed = 0;
            float gap = 0;
            
            for(int i = 1; i < stations.length; i++) {
                gap = stations[i] - stations[i-1];
                placed += Math.ceil(gap/mid) - 1;
            }

            return placed <= k;
        }
    
}
