class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }
        int[] char_vals = new int[150];

        for(int i=0; i<s.length(); i++) {
            int ch1 = s.charAt(i);
            int ch2 = t.charAt(i);
            char_vals[ch1]++;
            char_vals[ch2]--;
        }
        
        System.out.print(Arrays.toString(char_vals));
        for(int i: char_vals) {
            if(i != 0) {
                return false;
            }
        }

        return true;


    }
}