class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        int[] costArray = new int[n];
        Arrays.fill(costArray, Integer.MAX_VALUE);
        

        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0; i<n; i++) adj.add(new ArrayList<>());

        for(int[] flight : flights) {
            adj.get(flight[0]).add(new int[]{flight[1],flight[2]});
        }

        Queue<int[]> pq = new LinkedList<>();

        pq.add(new int[]{src,0,0});
        costArray[src] = 0;
        int level = 0;
        while(!pq.isEmpty()) {
            int[] curr = pq.poll();
            int city = curr[0], cost = curr[1], stops = curr[2];
            if(stops > k) continue;
            for(int[] neigh: adj.get(city)) {
                
                if(cost+neigh[1] < costArray[neigh[0]]) {
                    pq.add(new int[]{neigh[0],cost+neigh[1],stops+1});
                    costArray[neigh[0]] = cost+neigh[1];
                }  
            }

        }

      
        return costArray[dst] == Integer.MAX_VALUE?-1:costArray[dst];
     }
}