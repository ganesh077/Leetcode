class Solution {
    public int maxFrequencyElements(int[] nums) {
        Map<Integer,Integer> mymap = new HashMap<Integer,Integer>();
        int max_freq = 0;

        for (int num: nums) {
            int count = mymap.getOrDefault(num,0) + 1;
            mymap.put(num,count);

            if (count > max_freq) {
                max_freq = count;
            }
            
        }

        int total_freq = 0;
        for (Map.Entry<Integer,Integer> entry : mymap.entrySet()) {
            if (entry.getValue() == max_freq) {
                total_freq += entry.getValue();
            }
        }
        
        return total_freq;
    }
}