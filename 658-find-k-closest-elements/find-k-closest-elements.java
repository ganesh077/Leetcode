class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int start = 0;
        int end = arr.length - k;

        while (start < end) {
            int mid = (start + end) / 2;
            int distance_start = Math.abs(x - arr[start]);
            int distance_end = Math.abs(x - arr[end]);
            int distance_mid = Math.abs(x - arr[mid]);


            if((x - arr[mid]) <= (arr[mid + k] - x)) {
                end = mid;
            }
            else  {
                start = mid + 1;
            }
            
            
        }
        return Arrays.stream(arr, start, start + k)
                                 .boxed()
                                 .collect(Collectors.toList());
    }
}