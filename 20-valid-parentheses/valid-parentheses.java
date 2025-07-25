class Solution {
    public boolean isValid(String s) {
        
        Map<Character, Character> map = new HashMap<>();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');
        Stack<Character> stck = new Stack<>();

        for(char i: s.toCharArray()) {
            
            if(i == '(' || i == '{' || i == '[') {
                stck.push(i);
            }
            else {
                if(stck.isEmpty()) return false;
                else if(map.get(i) != stck.peek()) return false;
                else stck.pop();
            }
        }

        if(!stck.isEmpty()) return false;
        return true;
        
    }
}