class Solution {
    public int maxProfit(int[] prices) {
        int currMin = Integer.MAX_VALUE;
        int maxProfit = 0;

        for(int i=0; i<prices.length; i++) {
            if(prices[i] <= currMin) {
                currMin = prices[i];
                continue;
            }
            else {
                int currProfit = prices[i] - currMin;
                maxProfit = Math.max(maxProfit, currProfit);
            }

        }
        return maxProfit;
        
    }
}