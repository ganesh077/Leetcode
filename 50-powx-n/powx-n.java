class Solution {
    public double myPow(double x, int n) {
        // Promote n to long to handle Integer.MIN_VALUE correctly
        long N = n;
        if (N < 0) {
           return powHelper(1/x, -N);
        }
        return powHelper(x, N);
    }
    
    // Recursively compute x^N in O(log N) time
    private double powHelper(double x, long N) {
        // base case
        if (N == 0) {
            return 1;
        }
        // recurse on half exponent
     
        // if N is even: (x^(N/2))^2
        if (N % 2 == 0) {
            return powHelper(x*x, N / 2);
        } 
        // if N is odd: x * (x^(N/2))^2
        else {
            return x*powHelper(x*x, (N-1) / 2);
        }
    }
}