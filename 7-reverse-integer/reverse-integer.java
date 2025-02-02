class Solution {
    public int reverse(int x) {

        int temp = x;
        int res = 0;
        while (temp != 0) {
            int num = temp % 10;
            if (res > Integer.MAX_VALUE/10 || res < Integer.MIN_VALUE/10) {
                return 0;
            }
            res = res * 10 + num;
            temp = temp/10;
        }

        return res;
    }

}