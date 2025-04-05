class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int n = weights.length;
        int max = 0, sum = 0;
        for (int w : weights) {
            max = Math.max(max, w);
            sum += w;
        }
        
        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + weights[i];
        }
        
        int left = Math.max(max, (int)Math.ceil(sum / (double)days));
        int right = sum;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canShipWithBinarySearch(prefix, days, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
    
    // Optimized check using a precomputed prefix sum and binary search.
    private boolean canShipWithBinarySearch(int[] prefix, int days, int capacity) {
        int n = prefix.length - 1;
        int i = 0; // current index in weights
        for (int d = 0; d < days && i < n; d++) {
            int low = i + 1, high = n;
            int pos = i; // last valid position on this day
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (prefix[mid] - prefix[i] <= capacity) {
                    pos = mid;
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            
            if (pos == i) return false;  // Can't move forward, capacity too small
            i = pos;
        }
        return i == n;  // All packages are shipped
    }
}
