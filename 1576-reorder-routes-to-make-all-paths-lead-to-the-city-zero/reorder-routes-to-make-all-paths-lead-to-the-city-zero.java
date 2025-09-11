class Solution {
    public int minReorder(int n, int[][] connections) {
        //int n = connections.length;
        List<int[]>[] adj = new ArrayList[n];
        int res = 0;
        for(int i=0; i<n; i++) adj[i] = new ArrayList<>();
        for(int[] e: connections) {
            int a = e[0], b = e[1];
            adj[a].add(new int[]{b,1});
            adj[b].add(new int[]{a,0});
        }

        boolean[] seen = new boolean[n];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,0});
        seen[0] = true;
        

        while(!q.isEmpty()) {
            int[] curr  = q.poll();
            int node = curr[0], sign = curr[1];
            res += sign;
            for(int[] v: adj[node]) {
                int val = v[0], dir = v[1];
                if(!seen[val]) {
                    q.offer(new int[]{val,dir});
                    seen[val] = true;
                }
            }
        }

        return res;


    }
}