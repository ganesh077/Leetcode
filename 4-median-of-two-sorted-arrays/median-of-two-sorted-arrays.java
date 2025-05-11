class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length) return findMedianSortedArrays(nums2,nums1);

        int len1 = nums1.length;
        int len2 = nums2.length;
        int left=0, right=nums1.length;
        int half = (len1+len2+1)/2;
        

        while(left <= right) {
            int mid = (left+right)/2;
            int cutB = half - mid;
            int l1 = (mid == 0)      ? Integer.MIN_VALUE : nums1[mid - 1];
            int r1 = (mid == len1)   ? Integer.MAX_VALUE : nums1[mid];
            int l2 = (cutB == 0)     ? Integer.MIN_VALUE : nums2[cutB - 1];
            int r2 = (cutB == len2)  ? Integer.MAX_VALUE : nums2[cutB];

            if(l1<=r2 && l2<=r1) {
                if((len1+len2)%2 == 0) {
                    return (Math.max(l1,l2) + Math.min(r1,r2))/2.0;
                }
                else {
                    return (Math.max(l1,l2));
                }
            }
            else if(l2>r1) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }

        return -1;

}
}