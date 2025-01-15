class Solution {

    static String expand(String s, int a) {

        int left = a - 1;
        int right = a + 1;

        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) != s.charAt(right)) {
                return s.substring(left+1,right);
            }

            left -= 1;
            right += 1;
        }

        return s.substring(left+1,right);


    }

    static String expand(String s, int a, int b) {
        int left = a - 1;
        int right = b + 1;

        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) != s.charAt(right)) {
                return s.substring(left+1,right);
            }

            left -= 1;
            right += 1;
        }

        return s.substring(left+1,right);

    }
    public String longestPalindrome(String s) {
        
        String eve_palin = "";
        String odd_palin = "";
        String max = "";
        for (int i=0; i<s.length(); i++) {

            eve_palin = expand(s,i);
            if (eve_palin.length() > max.length()) {
                max = eve_palin;
            }
        }

        for (int i=0; i<s.length()- 1; i++) {
            if (s.charAt(i) == s.charAt(i+1)) {
                odd_palin = expand(s,i,i+1);
            }
            if (odd_palin.length() > max.length()) {
                max = odd_palin;
            } 

            
        }


        return max;
        
    }
}