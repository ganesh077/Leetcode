import java.util.Stack;
class Solution {
    public int maxDepth(String s) {
        int depth = 0;
        int max = 0;
        Stack stack = new Stack();
        for(char t: s.toCharArray()) {
            if(t == '(') {
                stack.push(s);
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