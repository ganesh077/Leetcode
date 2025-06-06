class Solution {
    public int myAtoi(String s) {
        boolean sign = false;
        int index = 0;
        int res = 0;
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;

        String trim_s = s.trim();

        if(trim_s.equals("")) {
            return 0;
        }

        char first = trim_s.charAt(0);

        if(first == '-' || first == '+') {
            sign = (first == '-') ? true:false;
            index++;
        }

        if(index < trim_s.length() && !Character.isDigit(trim_s.charAt(index))) {
            return 0;
        }

        while(index < trim_s.length()) {
            char c = trim_s.charAt(index);

            if(!Character.isDigit(c)) break;

            int digit = c - '0';

            if(res > max/10 || (res == max/10 && digit > max%10)) {
                return sign?min:max;
            }
            res = res * 10 + digit;
            index++;

        }

        return sign?-res:res;
    }
}