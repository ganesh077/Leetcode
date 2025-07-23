class Solution {
    public String alienOrder(String[] words) {
        Map<Character,Integer> indeg = new HashMap<>();
        Map<Character,List<Character>> adj = new HashMap<>();
        Set<Character> seen = new HashSet<>();
        for(int i=0; i<words.length; i++) {
            for(int j=0; j<words[i].length(); j++) {
                indeg.putIfAbsent(words[i].charAt(j),0);
                adj.putIfAbsent(words[i].charAt(j),new ArrayList<>());
                seen.add(words[i].charAt(j));
            }
        }
        
        Queue<Character> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<words.length-1; i++) {
            if (words[i].length() > words[i+1].length() && words[i].startsWith(words[i+1])) {
                return "";            // impossible dictionary
            }
            compare(words[i],words[i+1],adj,indeg);
        }

        for(Map.Entry<Character,Integer> vals: indeg.entrySet()) {
            //System.out.println(vals.getKey()+" "+vals.getValue());
            if(vals.getValue() == 0) {
                //System.out.println(vals.getKey());
                q.add(vals.getKey());
            }
        }

        while(!q.isEmpty()) {
            char curr = q.remove();
            sb.append(curr);
            //System.out.println(sb.toString());
            for(char neigh: adj.get(curr)){
                indeg.put(neigh,indeg.get(neigh)-1);
                if(indeg.get(neigh) == 0) {
                    q.add(neigh);
                }
            }
        }

        if(sb.toString().length() != seen.size()) return "";
        return sb.toString();
    }


    public void compare(String w1, String w2, Map<Character,List<Character>> adj, Map<Character,Integer> indeg) {
        int len1 = w1.length();
        int len2 = w2.length();

        int minlen = Math.min(len1,len2);

        for(int i=0; i<minlen; i++) {
            if(w1.charAt(i) != w2.charAt(i)) {
                adj.computeIfAbsent(w1.charAt(i),k -> new ArrayList<>()).add(w2.charAt(i));
                indeg.put(w2.charAt(i), indeg.get(w2.charAt(i))+1);
                break;
            }
            
        }
    }
}