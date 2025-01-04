class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        mymap = {}
        for i in range(len(nums)):
            val = target - nums[i]
            if val in mymap:
                return [mymap[val],i]
            mymap[nums[i]] = i
            