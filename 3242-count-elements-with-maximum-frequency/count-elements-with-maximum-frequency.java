class Solution {
    public int maxFrequencyElements(int[] nums) {
        Map<Integer,Integer> mymap = new HashMap<Integer,Integer>();
        int max_freq = 0;
        int max = 0;
        int min_freq = 0;
        int min = 0;

        for (int i=0; i<nums.length; i++) {
            if (mymap.containsKey(nums[i])) {
                mymap.put(nums[i],mymap.get(nums[i])+1);  
            }
            else {
                mymap.put(nums[i],1);
            }
            
        }

        for (Map.Entry<Integer,Integer> entry : mymap.entrySet()) {
            if (entry.getValue() > max_freq) {
                max_freq = entry.getValue();
                max = entry.getValue();
            }
            else if (entry.getValue() == max_freq) {
                max += entry.getValue();
            }
            System.out.println(max);
            
            //System.out.println(entry.getKey()+":"+entry.getValue());
        }
        
        return max;
    }
}