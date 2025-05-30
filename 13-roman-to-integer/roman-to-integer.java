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
            if(i < s.length()-1 && romans.get(s.charAt(i)) < romans.get(s.charAt(i+1))) {
                System.out.println("enter   "+s.charAt(i)+" "+s.charAt(i+1));
            

                sum -= romans.get(s.charAt(i));
                sum += romans.get(s.charAt(i+1));
                i+=1;
            }
            else {
            sum += romans.get(s.charAt(i));
            }
        }
        

        return sum;
    }
}