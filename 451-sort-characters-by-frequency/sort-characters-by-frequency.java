class Solution {
    public String frequencySort(String s) {
        int[] mymap = new int[256];

        for(int i: s.toCharArray()) {
            mymap[i]++;
        }

        List<List<Character>> buckets = new ArrayList<>();

        for(int i=0; i<=s.length(); i++) {
            buckets.add(new ArrayList<>());
        }

        for(int i=0; i<mymap.length; i++) {
            if(mymap[i] == 0) {
                continue;
            }
            buckets.get(mymap[i]).add((char)i);
        }

        System.out.println(buckets);

        StringBuilder sb = new StringBuilder();
        for(int i=s.length(); i>=0; i--) {
            for(int j=0; j<buckets.get(i).size(); j++) {
                for(int k=0; k<i; k++){
                    sb.append(buckets.get(i).get(j));
                }
            }
        }

        return sb.toString();




    }
}