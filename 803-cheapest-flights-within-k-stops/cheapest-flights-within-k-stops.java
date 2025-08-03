class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        int[][] costArray = new int[n][k + 2];
        for (int[] row : costArray) Arrays.fill(row, Integer.MAX_VALUE);
        

        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0; i<n; i++) adj.add(new ArrayList<>());

        for(int[] flight : flights) {
            adj.get(flight[0]).add(new int[]{flight[1],flight[2]});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((x,y) -> Integer.compare(x[1],y[1]));

        pq.add(new int[]{src,0,0});
        costArray[src][0] = 0;

        while(!pq.isEmpty()) {
            int[] curr = pq.poll();
            int city = curr[0], cost = curr[1], stops = curr[2];

            
            if(city == dst) return cost;
            if(stops > k) continue;
            
            for(int[] neigh: adj.get(city)) {
                int nextFlights  = stops + 1;
                if(cost+neigh[1] < costArray[neigh[0]][nextFlights]) {
                    pq.add(new int[]{neigh[0],cost+neigh[1],nextFlights});
                    costArray[neigh[0]][nextFlights] = cost+neigh[1];
                }  
            }
        }

      
        return -1;
     }
}