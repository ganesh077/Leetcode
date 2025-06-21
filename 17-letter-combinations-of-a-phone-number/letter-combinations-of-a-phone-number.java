class Solution {
    private static final String[] PHONE = {
        "",     // 0
        "",     // 1
        "abc",  // 2
        "def",  // 3
        "ghi",  // 4
        "jkl",  // 5
        "mno",  // 6
        "pqrs", // 7
        "tuv",  // 8
        "wxyz"  // 9
    };
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<String>();
        if(digits.isEmpty()) {
            return res;
        }
        generate(res,"",0,digits);
        return res; 
    }

    public void generate(List<String> res, String curr, int idx, String digits) {
        if(curr.length() == digits.length()) {
            res.add(curr);
            return;
        }

        String letters = PHONE[digits.charAt(idx) - '0'];

        for(int i=0; i<letters.length(); i++) {
            generate(res,curr + letters.charAt(i),idx+1,digits);
        }
    }
}