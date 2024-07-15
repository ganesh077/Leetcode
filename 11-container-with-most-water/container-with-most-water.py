class Solution:
    def maxArea(self, height: List[int]) -> int:
        left = 0
        right = len(height) - 1
        x_axis = len(height) - 1
        max_volume = -1

        if len(height) <= 1:
            return 0
        while left < right:
            if min(height[left],height[right]) * x_axis > max_volume:
                max_volume = min(height[left],height[right]) * x_axis
            if height[left] >= height[right]:
                right -= 1
            else:
                left += 1
            x_axis -= 1
            
            
        return max_volume

            



        