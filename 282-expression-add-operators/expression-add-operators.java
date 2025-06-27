class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<String>();
        backtrack(res,num,target,0,"",0l,0l);
        return res;
    }

    public void backtrack(List<String> res, String num, int target, int pos, String current, long eval, long lasteval) {
        if(pos == num.length()) {
            if(eval == target) {
                res.add(current);
            }
            
            return;
        }

        for(int i=pos; i<num.length(); i++) {
            if(i!=pos && num.charAt(pos) == '0') break;

            String nextstr = num.substring(pos,i+1);
            Long nextnum = Long.parseLong(num.substring(pos,i+1));
           
            if(pos == 0) {
                backtrack(res,num,target,i+1,nextstr,nextnum,nextnum);
            }

            else {
                backtrack(res,num,target,i+1,current + "+" + nextstr,eval + nextnum,nextnum);

                backtrack(res,num,target,i+1,current + "-" + nextstr,eval - nextnum,-nextnum);

                backtrack(res,num,target,i+1,current + "*" + nextstr,eval - lasteval + (lasteval * nextnum),lasteval * nextnum);
            }
        }
    }
}