class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordset = new HashSet<>(wordList);

        if(!wordset.contains(endWord)) return 0;

        Queue<String> q = new LinkedList<>();

        q.add(beginWord);
        int seqcount = 0;

        while(!q.isEmpty()) {
            seqcount++;
            int size = q.size();
            for(int i=0; i<size; i++) {
                String curr = q.remove();
                if(curr.equals(endWord)) return seqcount;
                findAdj(curr,q,wordset);
            }
        }

        return 0;
    }

    public void findAdj(String curr, Queue<String> q, Set<String> wordset) {
        int pos = 0;

        while(pos < curr.length()) {
            char[] temp = curr.toCharArray();
            for(int i=0; i<26; i++) {
                temp[pos] = (char)('a'+i);
                String str = new String(temp);
                if(!str.equals(curr) && wordset.contains(str)) {
                    q.add(str);
                    wordset.remove(str);
                }
            }
            pos++;   
        }
    }
}