class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordset = new HashSet<>(wordList);
        List<List<String>> res = new ArrayList<>();
        boolean isfound = false;

        if(!wordset.contains(endWord)) return res;

        if(wordset.contains(beginWord)) {
            wordset.remove(beginWord);
        }
        Map<String, HashSet<String>> parents = new HashMap<>();
        Queue<String> q = new LinkedList<>();

        q.add(beginWord);

        while(!q.isEmpty() && !isfound) {

            Set<String> level = new HashSet<>();
            
            int size = q.size();

            for(int i=0; i<size; i++) {
                String curr = q.remove();
                if(curr.equals(endWord)) {
                    isfound = true;
                }
                findAdj(curr,level,q,wordset,parents);
            }
            wordset.removeAll(level);
        }
        
        
        List<String> currlist = new ArrayList<>();
        currlist.add(endWord);
        dfs(endWord, beginWord, parents, res, currlist);
        return res;

    }

    public void findAdj(String curr,Set<String> nextlevel,Queue<String> q, Set<String> wordset,Map<String, HashSet<String>> parents) {
        int pos = 0;

        while(pos < curr.length()) {
            for(int i=0; i<26; i++) {
                char[] tmp = curr.toCharArray();
                tmp[pos] = (char)('a'+i);
                String str = new String(tmp);
                if(!str.equals(curr) && wordset.contains(str)) {
                    
                    parents.computeIfAbsent(str,k -> new HashSet<>()).add(curr);
                    if(nextlevel.add(str)) q.add(str);
                }
            }
            pos++;
        }
    }

    public void dfs(String curr, String target, Map<String, HashSet<String>> parents,  List<List<String>> res, List<String> currlist) {
        
        if(curr.equals(target)) {
            List<String> path = new ArrayList<>(currlist);
            Collections.reverse(path);
            res.add(path);
            return;
        }

        if(!parents.containsKey(curr)) return;

        for(String parent: parents.get(curr)) {
            currlist.add(parent);
            dfs(parent, target, parents, res, currlist);
            currlist.remove(currlist.size()-1);
        }
    }


    
}