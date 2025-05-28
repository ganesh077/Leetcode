class Solution {
    public String longestCommonPrefix(String[] strs) {

        if(strs.length == 0) {
            return "";
        }
        String first = strs[0];
        int len = first.length();

        for(int i=0; i<len; i++) {
            char ch = first.charAt(i);
            for(int j=1; j<strs.length; j++) {
                if(i >= strs[j].length() || ch != strs[j].charAt(i)) {
                    return first.substring(0,i);
                }
            }
        }

         return first;

}
}