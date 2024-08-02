class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        max = 0
        start,end = 0,1
        if len(prices) <= 1:
            return 0
        while end < len(prices):
            if prices[end] - prices[start] > max:
                max = prices[end] - prices[start]
            if prices[start] > prices[end]:
                start = end
            end += 1
        return max
        