import java.util.*;

class Solution {
    public int minCost(int n, int[][] edges) {
        // 1. Build the graph using an Adjacency List
        // adj.get(u) contains a list of {neighbor, weight}
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            // Forward edge: u -> v with cost w
            adj.get(u).add(new int[]{v, w});
            
            // Backward edge (Switch): v -> u with cost 2*w
            adj.get(v).add(new int[]{u, 2 * w});
        }

        // 2. Initialize Dijkstra's
        int[] distances = new int[n];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[0] = 0;

        // PriorityQueue stores {cost, node}, ordered by cost (ascending)
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        pq.offer(new int[]{0, 0}); // Start at node 0 with cost 0

        // 3. Main Loop
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int currentCost = current[0];
            int u = current[1];

            // If we found a shorter path to u before processing this one, skip
            if (currentCost > distances[u]) continue;

            // Optimization: If we reached the target, we can return immediately
            if (u == n - 1) return currentCost;

            // Explore neighbors
            for (int[] neighbor : adj.get(u)) {
                int v = neighbor[0];
                int weight = neighbor[1];

                // Relaxation step
                if (distances[u] + weight < distances[v]) {
                    distances[v] = distances[u] + weight;
                    pq.offer(new int[]{distances[v], v});
                }
            }
        }

        // 4. Return result
        // If distances[n-1] is still MAX_VALUE, it means we never reached it
        return distances[n - 1] == Integer.MAX_VALUE ? -1 : distances[n - 1];
    }
}