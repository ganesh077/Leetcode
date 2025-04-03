class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int min_speed = 1;
        int max_speed = findmax(piles);
        int ans = -1;

        while (min_speed <= max_speed) {
            int mid = min_speed + (max_speed - min_speed)/2;
            if(totalhours(mid,h,piles)) {
                max_speed = mid - 1;
                ans = mid;
            }
            else {
                min_speed = mid + 1;
            }
            
        }

        return ans;
    }

    public int findmax(int[] piles) {
        int max = -1;
        for(int pile:piles) {
            max = Math.max(max,pile);
        }
        return max;
    }

    public boolean totalhours(int speed,int allowedhours,int[] piles) {
        long sum = 0;
        for(int pile:piles) {
            sum = sum + (pile + speed - 1)/speed;
        }

        if(sum > allowedhours) {
            return false;
        } 
        return true;
    }
}