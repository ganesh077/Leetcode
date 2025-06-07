class Solution {
    public int beautySum(String s) {
        int sum = 0;
        for(int i=0; i<s.length(); i++) {
            int[] freq = new int[26];
            for(int j=i; j<s.length(); j++) {
                int c = s.charAt(j) - 'a';
                freq[c]++;

            int max = 0;
            int min = Integer.MAX_VALUE;

            for(int k=0; k<26; k++) {
                if(freq[k] > 0) {
                    max = Math.max(max, freq[k]);
                    min = Math.min(min, freq[k]);
                }
            }

            sum += (max - min);
        }
        }

        return sum;
    }

    
}