class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean[] visited = new boolean[numCourses];
        boolean[] path = new boolean[numCourses];

        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0; i<numCourses; i++) adj.add(new ArrayList<>());

        for(int[] pre: prerequisites) {
            adj.get(pre[1]).add(pre[0]);
        }

        for(int i=0; i<numCourses; i++) {
            if(!visited[i]) {
                if(isCycle(adj,i,visited,path)) return false;
            }
        }

        return true;
    }

    public boolean isCycle(List<List<Integer>> adj, int node, boolean[] visited, boolean[] path) {
        if (visited[node]) return false; 
        if(path[node]) return true;

        
        path[node] = true;

        for(int neigh: adj.get(node)) {
            if(isCycle(adj,neigh,visited,path)) return true;
        }

        visited[node] = true;
        path[node] = false;
        return false;
    }
}