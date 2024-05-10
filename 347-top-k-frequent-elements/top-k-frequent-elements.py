class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        #nums = set(sorted(nums))
        map = defaultdict(int)
        res = []
        max = -1
        j = 0
        for i in nums:
            map[i] += 1
        


        while k:
            for key,val in map.items():
                if val > max:
                    max = val
                    j = key
            res.append(j)
            print("___")
            del map[j]
            j = 0 
            max = -1
            k = k - 1
            
        return res