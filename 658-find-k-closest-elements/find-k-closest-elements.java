class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int start = 0;
        int end = arr.length - 1;

        while ((end - start) >= k) {
            int distance_start = Math.abs(x - arr[start]);
            int distance_end = Math.abs(x - arr[end]);

            if(distance_start < distance_end) {
                end -= 1;
            }
            else if (distance_start > distance_end) {
                start += 1;
            }
            else {
                if (arr[start] > arr[end]){
                    start += 1;
                }
                end -= 1;
            }
            
        }
        return Arrays.stream(arr, start, end + 1)
                                 .boxed()
                                 .collect(Collectors.toList());
    }
}