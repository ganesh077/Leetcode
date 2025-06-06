class Solution {
    public int myAtoi(String s) {
        // 1) Trim leading/trailing spaces
        String ss = (s == null) ? "" : s.trim();
        if (ss.isEmpty()) {
            return 0;
        }

        final int INT_MAX = Integer.MAX_VALUE; //  2147483647
        final int INT_MIN = Integer.MIN_VALUE; // -2147483648

        // 2) Handle optional sign
        int index = 0;
        boolean negative = false;
        char first = ss.charAt(0);

        if (first == '+' || first == '-') {
            negative = (first == '-');
            index++;
        }

        // 3) If next character is not a digit, return 0
        if (index >= ss.length() || !Character.isDigit(ss.charAt(index))) {
            return 0;
        }

        // 4) Parse digits and check overflow
        int result = 0;
        while (index < ss.length()) {
            char c = ss.charAt(index);
            if (!Character.isDigit(c)) break;

            int digit = c - '0';

            // Overflow check before multiplying
            if (result > INT_MAX / 10 || 
               (result == INT_MAX / 10 && digit > INT_MAX % 10)) {
                return negative ? INT_MIN : INT_MAX;
            }

            result = result * 10 + digit;
            index++;
        }

        return negative ? -result : result;
    }
}
