class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<String>();
        generate(ans,"",0,0,n);
        return ans;
    }

    public void generate(List<String> ans, String sb, int open, int close, int n) {
        if(sb.length() == 2*n) {
            ans.add(sb);
            return;
        }
        if(open < n) {
            generate(ans,sb+'(',open+1,close,n);
        }

        if(open > close) {
            generate(ans,sb+')',open,close+1,n);
        }
    }
}