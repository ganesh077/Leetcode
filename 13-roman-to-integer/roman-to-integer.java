class Solution {
    public int romanToInt(String s) {
        HashMap<Character, Integer> romans = new HashMap<>();
        int sum = 0;

        romans.put('I',1);
        romans.put('V',5);
        romans.put('X',10);
        romans.put('L',50);
        romans.put('C',100);
        romans.put('D',500);
        romans.put('M',1000);

        for(int i=0; i<s.length(); i++) {
            int curr = romans.get(s.charAt(i));
            int next = (i+1 < s.length())? romans.get(s.charAt(i+1)):0;

            sum+= (curr < next? next - curr : curr);

            if(curr < next) {
                i++;
            }
        }
        

        return sum;
    }
}