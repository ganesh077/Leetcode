class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<List<String>>();
        generate(res,s,new ArrayList(),0);
        return res;
    }

    public void generate(List<List<String>> res, String s, List<String> current, int idx) {

        
        if(idx == s.length()) {
            res.add(new ArrayList(current));
            return;
        }

        for(int i=idx; i<s.length(); i++) {
            if(isPalin(s,idx,i+1)) {
                current.add(s.substring(idx,i+1));
                generate(res,s,current,i+1);
                current.remove(current.size()-1);

            }
        }

    }

    public boolean isPalin(String s, int start, int end) {
        --end;
        while(start < end) {
            if (s.charAt(start++) != s.charAt(end--)) return false;
        }

        return true;
    }
}