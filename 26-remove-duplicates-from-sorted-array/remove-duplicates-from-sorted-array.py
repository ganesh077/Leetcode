class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        seen = set()
        unique = 0
        for i in nums:
            if i not in seen:
                seen.add(i)
                nums[unique] = i
                unique += 1
        #print(seen)
        return unique
                

        