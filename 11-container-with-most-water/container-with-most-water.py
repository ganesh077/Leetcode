class Solution:
    def maxArea(self, height: List[int]) -> int:
        left = 0
        right = len(height) - 1
        max_water = 0
        x_axis = len(height) - 1
        while left < right:
            side = min(height[left],height[right])
            max_water = max(max_water, side*x_axis)

            if height[left] >= height[right]:
                right -= 1
            else:
                left += 1
            x_axis -= 1

        return max_water


        