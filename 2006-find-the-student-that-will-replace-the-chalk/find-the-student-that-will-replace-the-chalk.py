class Solution:
    def binary(self,prefix,remainder):
        low = 0
        high = len(prefix) - 1
        while low < high:
            mid = (low + high)//2
            if prefix[mid] <= remainder:
                low = mid + 1
            else:
                high = mid
        return high
    def chalkReplacer(self, chalk: List[int], k: int) -> int:
        i = 0
        total = sum(chalk)
        n = len(chalk)
        cum_sum,temp = [0]*n,0
        for i in range(n):
            temp += chalk[i]
            cum_sum[i] = temp

        k = k%cum_sum[-1]

        return self.binary(cum_sum,k)
        
        
        
            