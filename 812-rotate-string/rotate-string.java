class Solution {
    public boolean rotateString(String s, String goal) {
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<s.length(); i++) {
            sb.append(s.substring(i+1,s.length())+s.substring(0,i+1));
            System.out.println(sb.toString());
            if(sb.toString().equals(goal)) {
                return true;
            }
            sb.setLength(0);
        }

        return false;
    }
}