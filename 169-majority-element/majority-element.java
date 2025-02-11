class Solution {
    public int majorityElement(int[] nums) {
        int mid = nums.length/2;
        if (nums.length <= 1) {
            return nums[0];
        }
        Map<Integer, Integer> freqmap = new HashMap<Integer, Integer>();

        for (int i: nums) {
            if (freqmap.containsKey(i)) {
                freqmap.put(i,freqmap.get(i)+1);
                if (freqmap.get(i) > mid) {
                    return i;
                } 
            }
            else {
                freqmap.put(i,1);
            }
            
        }

        System.out.print(Arrays.toString(freqmap.entrySet().toArray()));
        return 1;
    }
}