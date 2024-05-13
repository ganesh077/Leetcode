class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        prefix = []
        postfix = []
        pre_run = 1
        post_run = 1
        res = []
        for i in range(len(nums)):
            pre_run *= nums[i]
            prefix.append(pre_run)
        
        for i in range(len(nums)-1,-1,-1):
            post_run *= nums[i]
            postfix.append(post_run)
        
        postfix = postfix[::-1]
        
        print(prefix)
        print(postfix)

        while i < len(nums) - 1:
            if i-1 < 0:
                res.append(postfix[i+1])
            else:
                res.append(prefix[i-1]*postfix[i+1])
            i+=1
        res.append(prefix[len(nums)-2])
                
        return res



        