class Solution {
    double res = 0;
    public double myPow(double x, int n) {
        
        if(n == 0 || x == 1) {
            return 1;
        }

        if(x == -1) {
            if(n < 0) {
                return 1;
            }
            return -1;
        }

        if(n < 0) {
            x = 1/x;
            n = -1*n;
        }
        
        

        if(res + 32 > Integer.MAX_VALUE/n) {
            return 0;
        }
        
        res = res + (x*myPow(x,n-1));
        
        
        return res;
    }
}