class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];

        List<Integer> safe = new ArrayList<>();

        for(int i=0; i<n; i++) {
            if(dfs(i,color,graph)) {
                safe.add(i);
            }
        }
        
        return safe;
    }

    public boolean dfs(int node,int[] color,int[][] graph) {
        if(color[node] != 0) {
            return color[node] == 2;
        }

        color[node] = 1;

        for(int neigh: graph[node]) {
            if(!dfs(neigh,color,graph)) return false;
        }

        color[node] = 2;
        return true;

    }
}