class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        nums = set(nums)
        max_val = 0
        length = 0
        for i in nums:
            if i-1 not in nums:
                length = 0
                while i+length in nums:
                    length += 1
            max_val = max(max_val,length)
        return max_val

                
                
