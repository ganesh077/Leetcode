import java.util.Stack;
class Solution {
    public int maxDepth(String s) {
        int depth = 0;
        int max = 0;
        for(char t: s.toCharArray()) {
            if(t == '(') {
                depth++;
                if(depth > max) {
                    max = depth;
                }
            }
            else if (t == ')') {
                depth--;
            }

        }

        return max;
    }
}