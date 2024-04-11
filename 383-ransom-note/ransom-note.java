class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> myMap = new HashMap<>();

        for(int i = 0;i < magazine.length(); i++ ) {
            if(myMap.containsKey(magazine.charAt(i))) 
            {
                char val = magazine.charAt(i);
                myMap.put(val,myMap.get(val)+1);
            }
            else {
                 myMap.put(magazine.charAt(i),1);
            }            
             
        }

        for(int i = 0;i < ransomNote.length(); i++ ) {
            if(myMap.containsKey(ransomNote.charAt(i))) 
            {
                char val = ransomNote.charAt(i);
                if(myMap.get(val) == 0) {
                    return false;
                }
                myMap.put(val,myMap.get(val)-1);
            }
            else {
                return false;
            }
            
        }

        
        return true;
    }
}