class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        int[] prefix = new int[weights.length+1];
        int iter = 0;
        for(int weight: weights) {
            max = Math.max(max,weight);
            sum += weight;
            prefix[iter+1] = sum;
            iter++;
        }
        int left = Math.max(max, sum/days);
        int right = Math.min(sum,sum/days+max);

        while (left <= right) {
            int mid = left + (right - left)/2;
            if(cargocheck(weights,days,mid,prefix)) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }

        return left;
    }

    public boolean cargocheck(int[] weights,int days,int current,int[] prefix) {
        int len = prefix.length-1;
        int k = 0;
        for(int i=0; i<days && k<len; i++) {
            int left = k+1, right = len;
            int pos = k;
            while (left <= right) {
                int mid = left + (right - left)/2;
                if(prefix[mid] - prefix[k] <= current) {
                    pos = mid;
                    left = mid + 1;
                }
                else {
                    right = mid - 1;
                }
            }
            if(pos == k) return false;
            k = pos;
        }

        return k == len;
    }
}