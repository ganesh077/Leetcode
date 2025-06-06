class Solution {
    public String longestPalindrome(String s) {
        if(s.length() == 0) {
            return "";
        }
        if(s.length() == 1) {
            return s;
        }
        int max = Integer.MIN_VALUE;
        String res = "";
        for(int i=0; i<s.length()-1; i++) {
            for(int j=i; j<s.length(); j++) {
                if(isPaling(s.substring(i,j+1))) {

                    if(s.substring(i,j+1).length() > max) {
                        max = s.substring(i,j+1).length();
                        res = s.substring(i,j+1);
                    }
                }
            }
         }

    return res;
    }


    public boolean isPaling(String s) {
        int left = 0;
        int right = s.length()-1;

        while(left <= right) {
            if(s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}