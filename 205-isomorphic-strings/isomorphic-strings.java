class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character,Character> mymap = new HashMap<>();
        HashMap<Character,Character> mymap1 = new HashMap<>();

        for(int i=0; i<s.length(); i++) {
            if(!mymap.containsKey(s.charAt(i))) {
                mymap.put(s.charAt(i),t.charAt(i));
            }
            else {
                if(mymap.get(s.charAt(i)) != t.charAt(i)) {
                    return false;
                }
            }
        }

        System.out.println("s->t"+mymap);


        for(int i=0; i<t.length(); i++) {
            if(!mymap1.containsKey(t.charAt(i))) {
                mymap1.put(t.charAt(i),s.charAt(i));
                System.out.println("t->s"+mymap);
            }
            else {
                if(mymap1.get(t.charAt(i)) != s.charAt(i)) {
                    return false;
                }
            }
        }

        

        return true;
    }
}