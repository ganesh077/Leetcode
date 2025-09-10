class Solution {
    public int countElements(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;

        for(int i: arr) {
            map.put(i, map.getOrDefault(i,0)+1);
        }

        for(int i : map.keySet()) {
            if(map.containsKey(i+1)) {
                
                    res += map.get(i);
                
            }
        }

        return res;
}

}