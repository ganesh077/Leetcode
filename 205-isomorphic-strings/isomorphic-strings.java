class Solution {
    public boolean isIsomorphic(String s, String t) {
        int map1[] = new int[256];
        int map2[] = new int[256];

        for(int i=0; i<s.length(); i++) {
            int c1 = s.charAt(i);
            int c2 = t.charAt(i);
            if(map1[c1] == 0 && map2[c2] == 0) {
                map1[c1] = i + 1;
                map2[c2] = i + 1;
            }
            else {
                if(map1[c1] != map2[c2]) {
                    return false;
                }
            }
        }

        return true;


        
}

}