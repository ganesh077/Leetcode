class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        map = defaultdict(list)
        res = []
        for i in strs:
            map[str(sorted(i))].append(i)
        
        for i,j in map.items():
            res.append(j)

        return res
        
        