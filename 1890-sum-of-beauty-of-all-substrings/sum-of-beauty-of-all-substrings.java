class Solution {
    public int beautySum(String s) {
        int sum = 0;
        int beauty = 0;
        for(int i=0; i<s.length(); i++) {
            for(int j=i; j<s.length(); j++) {
                sum += bcalcB(s,i,j);
            }
        }
        return sum;
    }

    public int bcalcB(String s, int start, int end) {
        int[] freq = new int[130];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i=start; i<=end; i++) {
            int c = s.charAt(i);
            freq[c]++;  
        }

        //System.out.print(Arrays.toString(freq));
        
        for(int i=0; i<freq.length; i++) {
            if(freq[i] == 0) {
                continue;
            }
            max = Math.max(max, freq[i]);
            min = Math.min(min, freq[i]);
        }

        return max - min;
    }
}