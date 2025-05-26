import java.util.Stack;
class Solution {
    public String removeOuterParentheses(String s) {
        int depth = 0;
        StringBuilder sb = new StringBuilder();
        char[] chara = s.toCharArray();
        for(int i=0; i<chara.length; i++) {
            if(chara[i] == '(') {
                if(depth > 0) {
                    sb.append(chara[i]);
                }
                depth++;
            }
            else {
                depth--;
                if(depth > 0) {
                    sb.append(chara[i]);
                }
            }
        }

        return sb.toString();
}
}