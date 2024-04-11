class Solution:
    def intersection(self, nums1: List[int], nums2: List[int]) -> List[int]:
        left_point = 0
        right_point = 0
        res = []

        nums1.sort()
        nums2.sort()

        while left_point < len(nums1) and right_point < len(nums2):
            if nums1[left_point] < nums2[right_point]:
                left_point += 1
            elif nums1[left_point] == nums2[right_point]:
                if nums1[left_point] not in res:
                    res.append(nums1[left_point])
                left_point += 1
                right_point += 1
            else:
                right_point += 1

        return res

        