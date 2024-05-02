class Solution:
    def containsDuplicate(self, nums: List[int]) -> bool:
        nums = sorted(nums)
        for i in range(1,len(nums)):
            print(nums[i])
            if nums[i] == nums[i-1]:
                print("enter",nums[i],nums[i-1])
                return True
        return False
        
        