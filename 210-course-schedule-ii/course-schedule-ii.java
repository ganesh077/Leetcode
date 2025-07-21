class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        boolean[] visited = new boolean[numCourses];
        boolean[] path = new boolean[numCourses];
        List<Integer> res = new ArrayList<>();

        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0; i<numCourses; i++) adj.add(new ArrayList<>());

        for(int[] pre: prerequisites) {
            adj.get(pre[1]).add(pre[0]);
        }

        for(int i=0; i<numCourses; i++) {
            if(!visited[i]) {
                if(isCycle(adj,i,visited,path,res)) return new int[0];
            }
        }

        Collections.reverse(res);
        int[] ans = res.stream().mapToInt(i -> i).toArray();
        return ans;
    }

    public boolean isCycle(List<List<Integer>> adj, int node, boolean[] visited, boolean[] path,List<Integer> res) {
        if (visited[node]) return false; 
        if(path[node]) return true;

        
        path[node] = true;

        for(int neigh: adj.get(node)) {
            if(isCycle(adj,neigh,visited,path,res)) return true;
        }

        visited[node] = true;
        path[node] = false;
        res.add(node);
        return false;
    }
    }