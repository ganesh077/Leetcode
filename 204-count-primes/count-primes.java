class Solution {
    public int countPrimes(int n) {
        if(n < 2) {
            return 0;
        }
        int count = 0;
        boolean[] isComposite = new boolean[n];

        for(int i=2; i<=(int)Math.sqrt(n); i++) {
            if(!isComposite[i]) {
                for(int k=i*i; k<n; k+=i) {
                    //System.out.println(k);
                    isComposite[k] = true;
                }
            }
        }

        for(int i=2; i<n; i++ ) {
            if(!isComposite[i]) {
                count++;
            }
        }

        return count;

    }
}