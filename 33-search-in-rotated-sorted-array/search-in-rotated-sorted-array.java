class Solution {
    public int search(int[] nums, int target) {
        int findpivot = binaryPivotSearch(nums);
        //System.out.print(findpivot);
        if (findpivot <= 0 || nums.length <= 1) {
            //System.out.print("enter");
            return binarySearch(nums,target);
        }
        int[] rightarray = Arrays.copyOfRange(nums,findpivot,nums.length);
        int[] leftarray = Arrays.copyOfRange(nums,0,findpivot);

        int rightsearch = binarySearch(rightarray,target);
        int leftsearch = binarySearch(leftarray,target);

        //System.out.print(leftarray.length);

        if (rightsearch == -1 && leftsearch == -1) {
            return -1;
        }
        else if (rightsearch != -1) {
            return rightsearch+findpivot;
        }
        else {
            return leftsearch;
        }

    }

    public int binaryPivotSearch(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] > arr[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public int binarySearch(int[] arr,int target) {
        if (arr.length == 0) {
            return -1;
        }

        int left=0, right=arr.length-1;

        while(left <= right) {
            int mid = left + (right - left)/2;

            if(arr[mid] == target) {
                return mid;
            }
            else if (arr[mid] > target) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }

        return -1;
    }
}