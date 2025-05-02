class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int point_left = 0;
        int point_right = 0;
        ArrayList<Double> res = new ArrayList<Double>();

        while(point_left < nums1.length && point_right < nums2.length) {
            if(nums1[point_left] < nums2[point_right]) {
                res.add((double)nums1[point_left]);
                point_left++;
            }
            else {
                res.add((double)nums2[point_right]);
                point_right++;
            }
        }

        while(point_left < nums1.length) {
            res.add((double)nums1[point_left]);
            point_left++;
        }

        while(point_right < nums2.length) {
            res.add((double)nums2[point_right]);
            point_right++;
        }

        for (double val : res) {
             System.out.print(val + " ");
}
// Output: 10 20 30

        int mid = res.size()/2;
        if(res.size()%2 == 0 && mid-1 >= 0) {
            return (res.get(mid)+res.get(mid-1))/2 ;
        }
        return res.get(mid);

    }
}