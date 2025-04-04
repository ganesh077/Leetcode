class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for(int weight: weights) {
            max = Math.max(max,weight);
            sum += weight;
        }
        int left = max;
        int right = sum;

        while (left <= right) {
            int mid = left + (right - left)/2;
            if(cargocheck(weights,days,mid,sum)) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }

        return left;
    }

    public boolean cargocheck(int[] weights,int days,int current,int totalsum) {
        int sum = 0;
        int iterate = 0;
        while(days > 0) {
            while (iterate < weights.length && (sum+weights[iterate]) <= current) {
                sum += weights[iterate];
                iterate++;
            }
            totalsum -= sum;
            sum = 0;
            days--; 
        }

        if (totalsum > 0) {
            return false;
        }
        return true;
    }
}