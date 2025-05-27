class Solution {
    public String largestOddNumber(String num) {
        StringBuilder sb = new StringBuilder();
        String res = "";
        for(int i=0; i<num.length(); i++) {
            sb.append(num.charAt(i));
            if(Integer.parseInt(num.charAt(i)+"")%2 != 0){
                res = sb.toString();
            }
        }

        return res;
    }
}