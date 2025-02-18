class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> myset = new HashSet<Integer>();
        int result = 0;

        for(int num: nums) {
            myset.add(num);
        }

        for (int num: myset) {
            if (!myset.contains(num-1)) {
                int start  = num;
                int count = 1;
                while (myset.contains(start+1)) {
                    start++;
                    count++;
                }
                result = Math.max(result, count);
            }  
        }

        return result;
     }
}