class Solution {
    public int myAtoi(String s) {
        String ss = s.trim();
        //System.out.print(no_space);
        int sign = 1;
        StringBuilder sb = new StringBuilder();
        int index = 0;
        int res = 0;
        final int INT_MAX = Integer.MAX_VALUE;
        final int INT_MIN = Integer.MIN_VALUE;

        if (ss.equals("")) {
            return 0;
        }


        if(!Character.isDigit(ss.charAt(0)) && ss.charAt(0) != '-' && ss.charAt(0) != '+') {
            return 0;
        }
        
        
        while(index < ss.length()) {
            if(!Character.isDigit(ss.charAt(index))) {
                if(index > 0) {
                    return 0;
                }
                index++;
                continue;
            }
            while(index < ss.length() && Character.isDigit(ss.charAt(index))) {
                if(index > 0) {
                    if(ss.charAt(index-1) == '-') {
                        sign = -1;
                    }
                }
                int digit = ss.charAt(index) - '0';

                if(res > INT_MAX/10 || (res == INT_MAX/10 && digit > INT_MAX % 10)) {
                    return (sign == -1)? INT_MIN:INT_MAX;
                }
                
                res = res * 10 + digit;
                
                index++;
                }
            break;
        }

      
        return res*sign;
    }
}