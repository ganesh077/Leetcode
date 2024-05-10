class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        #nums = set(sorted(nums))
        map = defaultdict(int)
        res = []
        for i in nums:
            map[i] += 1
        count = [[] for _ in range(len(nums)+1)]
        for key,val in map.items():
            count[val].append(key)
        for i in range(len(count)-1,0,-1):
            for j in count[i]:
                res.append(j)
            if len(res) == k:
                return res
         
        