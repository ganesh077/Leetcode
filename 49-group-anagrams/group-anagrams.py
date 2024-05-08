class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        map = defaultdict(list)
        # res = []
        # for i in strs:
        #     map[str(sorted(i))].append(i)
        
        # for i,j in map.items():
        #     res.append(j)

        # return res
        res = defaultdict(list)
        result = []
        for i in strs:
            count = [0] * 26

            for j in i:
                count[ord(j) - ord('a')] += 1
            
            res[tuple(count)].append(i)
        
        return [i for i in res.values()]

        
        