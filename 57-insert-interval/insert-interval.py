class Solution:
    def insert(self, intervals: List[List[int]], newInterval: List[int]) -> List[List[int]]:
        start = 0
        end = 1
        pos = 0
        for i in intervals[:]:
            if i[end] < newInterval[start] :
                pos += 1
            else:
                if i[start] <= newInterval[start]:
                    newInterval[start] = i[start]
                    newInterval[end] = max(newInterval[end],i[end])
                    intervals.remove(i)
                    
                elif i[end] >= newInterval[end] and newInterval[end] >= i[start]:
                    newInterval[end] = max(newInterval[end],i[end])
                    intervals.remove(i)
                elif i[end] <= newInterval[end]:
                    intervals.remove(i)
                    
        intervals.insert(pos,newInterval)
        return intervals
        