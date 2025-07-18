class Solution {
    public String reverseWords(String s) {
        String t = s.trim();

        String[] parts = t.split("\s+");
        StringBuilder sb = new StringBuilder();
        for(int i=parts.length-1; i>=0; i--) {
            sb.append(parts[i]+" ");
        }

        return sb.toString().trim();
    } 
}