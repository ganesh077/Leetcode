class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0 ) {
            return false;
        }

        if (x == reverse(x)) {
            return true;
        }
        else {
            return false;
        }

        
    }

    static int reverse(int x) {
        int temp = x;
        int res = 0;
        while (temp > 0) {
            int num = temp % 10;
            res = res * 10 + num;
            temp = temp/10;
        }
        return res;
    }
}