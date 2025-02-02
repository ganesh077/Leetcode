class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x !=0 && x % 10 == 0)) {
            return false;
        }
        int temp = x;
        int res = 0;
        while (temp > res) {
            res = res * 10 + (temp%10);
            temp = temp/10;
        }
        if (temp == res || temp == res/10) {
            return true;
        }
        else {
            return false;
        }
        

        
    }

}