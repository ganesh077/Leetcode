class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<String>();
        generate(ans,new StringBuilder(),0,0,n);
        return ans;
    }

    public void generate(List<String> ans, StringBuilder sb, int open, int close, int n) {
        if(sb.length() == 2*n) {
            ans.add(sb.toString());
            return;
        }

        if(open < n) {
            sb.append('(');
            generate(ans,sb,open+1,close,n);
            sb.deleteCharAt(sb.length()-1);
        }

        if(open > close) {
            sb.append(')');
            generate(ans,sb,open,close+1,n);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}