class Solution {
    public int findKthPositive(int[] arr, int k) {
        int count = 0;
        int j = 1;
        int i = 0;
        while(j <= arr[arr.length-1] && i < arr.length) {
            System.out.println(j);
            if(j != arr[i]){
                j++;
                count++;
            }
            else {
                i++;
                j++;
            }
            if(count == k) {
                return j-1;
            }
        }
        return j-1+k-count;
    }
}