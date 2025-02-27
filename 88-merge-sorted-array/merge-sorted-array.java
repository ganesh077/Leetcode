class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
         int point_m = m-1;
         int point_n = n-1;
         int point = (m+n)-1;

         while (point_n >= 0 && point_m >= 0) {
            if (nums1[point_m] > nums2[point_n]) {
                nums1[point] = nums1[point_m];
                point_m--;
                point--;
            }
            else {
                nums1[point] = nums2[point_n];
                point_n--;
                point--;
            }
         }
    
         while (point_n >=0) {
            nums1[point] = nums2[point_n];
            point--;
            point_n--;
         }
    }
}