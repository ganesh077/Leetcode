class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
         int point_m = 0;
         int point_n = 0;
         int k = m;

         while (point_n < n && point_m < m) {
            if (nums1[point_m] <= nums2[point_n]) {
                point_m++;
            }
            else {
                k = m;
                while (k > point_m) {
                    nums1[k] = nums1[k-1];
                    k--;
                }
                nums1[point_m] = nums2[point_n];
                point_n++;
                m++;
            }
         }
    
         for (int i=point_n; i<n; i++) {
            nums1[m] = nums2[i];
            m++;
         }
    }
}