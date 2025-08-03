class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> adj = new ArrayList<>();

        for(int i=0; i<n; i++) adj.add(new ArrayList<>());

        for(int[] time: times) {
            int from = time[0]-1, to = time[1]-1, w = time[2];
            adj.get(from).add(new int[]{to,w});
        }

        int[] cost = new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>((x,y) -> Integer.compare(x[1],y[1]));
        pq.add(new int[]{k-1,0});
        cost[k-1] = 0; 

        while(!pq.isEmpty()) {
            int[] curr = pq.poll();
            int node = curr[0], time = curr[1];
            //System.out.println(node + " " + time + " " + cost[node]);
            if(time > cost[node]) continue;
            for(int[] neigh: adj.get(node)) {
                int n_node = neigh[0], n_time = neigh[1];
                //System.out.println(n_node + " " + n_time + " " + cost[n_node]);
                if(time + n_time < cost[n_node]) {
                    cost[n_node] = time + n_time;
                    pq.add(new int[] {n_node, time+n_time});
                }
            }
        }

        System.out.println(Arrays.toString(cost));

        int max = Integer.MIN_VALUE;
        for(int i=0; i<n; i++) {
            if(cost[i] == Integer.MAX_VALUE) {
                return -1;
            }
            max = Math.max(cost[i],max);

        }

        return max;
    }
}