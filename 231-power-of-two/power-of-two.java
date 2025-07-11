class Solution {
    public boolean isPowerOfTwo(int n) {
        long base = 1;

        while (base <= n) {
            if(base == n) {
                return true;
            }
            base = base << 1;
        }

        return false;
    }
}