class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> mylist = new  ArrayList<List<Integer>>();

        for(int i=0; i<n; i++) {
            mylist.add(new ArrayList<>());
        }

        for(int i=0; i<edges.length; i++) {
            mylist.get(edges[i][0]).add(edges[i][1]);
            mylist.get(edges[i][1]).add(edges[i][0]);
        }


        boolean[] visit = new boolean[n];
        int components = 0;
        for(int i=0; i<n; i++) {
            if(!visit[i]) {
                dfs(i,mylist,visit);
                components++;
            }
        }
        return components;

    }

    public void dfs(int val, List<List<Integer>> mylist, boolean[] visit) {
        visit[val] = true;
        for(int i: mylist.get(val)) {
            if(!visit[i]) {
                dfs(i,mylist,visit);
            }
        }
        
    }
}