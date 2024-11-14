class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        temp = {}
        for index,i in enumerate(nums):
            val = target - i
            print(val,index)
            if val in temp:
                return [temp[val],index]
            else:
                temp[i] = index
        return []


        