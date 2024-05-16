class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        nums = sorted(set(nums))
        start = 0 
        max_val = 0
        print(nums)
        if len(nums) == 1:
            return 1
        for end in range(len(nums)-1):
            if nums[end]+1 != nums[end+1]:
                start = end+1
            max_val = max(end + 2 - start,max_val)
        
            
        return max_val

                
                
