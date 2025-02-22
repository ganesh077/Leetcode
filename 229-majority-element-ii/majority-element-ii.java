class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int len = nums.length/3;

        HashMap<Integer,Integer> freqMap = new HashMap<Integer, Integer>();
        ArrayList<Integer> result = new ArrayList<Integer>();

        for (int num: nums) {
            freqMap.put(num,freqMap.getOrDefault(num,0)+1);
            if (freqMap.get(num) > len && !result.contains(num)) {
                result.add(num);
            }
        }

        return result;
    }
}