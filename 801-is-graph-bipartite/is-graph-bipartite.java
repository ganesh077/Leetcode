class Solution {
    public boolean isBipartite(int[][] graph) {
        Queue<int[]> q = new LinkedList<>();
        Map<Integer,Integer> color = new HashMap<>();
        boolean[] visited = new boolean[graph.length];
        
        
        for(int i=0; i<graph.length; i++) {
            int base = 1;
            if(!visited[i]) {
                if(!bfs(i,graph,visited,q,base, color)) return false;;
            }  
        } 

        return true;
    }

    public boolean bfs(int node, int[][] graph, boolean[] visited, Queue<int[]> q,int base,Map<Integer,Integer> color) {
        q.add(new int[]{node,base});
        color.put(node,base);

        while(!q.isEmpty()) {
            base *= -1;
            int size = q.size();

            for(int i=0; i<size; i++) {
                int curr = q.remove()[0];
                visited[curr] = true;
                for(int adj: graph[curr]) {
                    if(!visited[adj]) {
                        q.add(new int[]{adj,base});
                        color.put(adj,base);
                    }
                    else {
                        if(color.get(adj) != base) return false;
                    }
                }
            }
        }

        return true;
    }
}