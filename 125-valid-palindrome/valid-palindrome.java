
class Solution {
    public boolean isPalindrome(String s) {
        if (s.length() <=1) {
            return true;
        }
        s = s.toLowerCase();
        s = s.replaceAll("[^a-z0-9]","");

        return palindrome(s);
    }

    static boolean palindrome(String s) {
        
        int first = 0;
        int last = s.length()-1;

        while ( first <= last) {
            if (s.charAt(first) != s.charAt(last)) {
                return false;
            }
            first += 1;
            last -= 1;
        }
        return true;
    }
}