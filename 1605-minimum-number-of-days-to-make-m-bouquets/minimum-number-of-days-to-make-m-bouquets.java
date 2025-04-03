class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int left = min(bloomDay);
        int right = max(bloomDay);
        int ans = -1;

        while (left <= right) {
            int mid = left + (right - left)/2;

            if(bouquet(bloomDay,mid,m,k)) {
                right = mid - 1;
                ans = mid;
            }
            else {
                left = mid + 1;
            }
        }
        return ans;
    }
    public int max(int[] days){
        int max = Integer.MIN_VALUE;
        for(int day:days) {
            max = Math.max(day,max);
        }
        return max;
    }

    public int min(int[] days){
        int min = Integer.MAX_VALUE;
        for(int day:days) {
            min = Math.min(day,min);
        }

        return min;
    }

    public boolean bouquet(int[] bloomDay,int checkday,int m,int k) {
        int temp = 0;
        int required = 0;
        for(int i=0; i<bloomDay.length; i++) {
            if(bloomDay[i] <= checkday) {
                temp++;
                if(temp == k) {
                    required++;
                    temp = 0;
                }  
            }
            else {
                temp = 0;
            }
        }
        if(required >= m) {
            return true;
        }
        return false;
    }
}