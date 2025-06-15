class Solution {
    long mod = 1000000007;
    public int countGoodNumbers(long n) {
        
        return (int)((power(5l,(n+1)/2,mod)*power(4l,n/2,mod))%mod);
    }

    public long power(long base,long pow, long mod) {
        if(pow==0) {
            return 1;
        }
        if(pow%2 == 0) {
            return power(base*base%mod, pow/2, mod);
        }
        else {
            return base*power(base*base%mod, pow/2, mod)%mod;
        }
    }
}