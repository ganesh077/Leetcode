class Solution {
    public int countElements(int[] arr) {
        int n = arr.length;
        if(n <= 1) return  0;
        Arrays.sort(arr);
        int i=0, res = 0, j =0;
        
        while(i < n && j < n) {
            if(arr[j] < arr[i] + 1) {
                j++;
            }
            else if (arr[j] > arr[i] + 1){
                i++;
            }
            else {
                int cnt = 0, v=arr[i];
                while(i < n && arr[i] == v) {
                    i++;
                    cnt++;
                }
                res += cnt;
            }

            
        }

        return res;

}}