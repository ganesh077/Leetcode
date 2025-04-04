class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for(int weight: weights) {
            max = Math.max(max,weight);
            sum += weight;
        }
        int left = Math.max(max, sum/days);
        int right = Math.max(sum, max+sum/days);

        while (left <= right) {
            int mid = left + (right - left)/2;
            if(cargocheck(weights,days,mid)) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }

        return left;
    }

    public boolean cargocheck(int[] weights,int days,int current) {
        
        int daysNeeded = 1;
        int currentLoad = 0;
        for (int w : weights) {
            if (currentLoad + w > current) {
                daysNeeded++;
                currentLoad = 0;
            }
            currentLoad += w;
        }
        return daysNeeded <= days;
    }
}