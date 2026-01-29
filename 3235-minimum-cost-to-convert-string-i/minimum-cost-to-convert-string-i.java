import java.util.Arrays;

class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        // Step 1: Initialize the distance matrix
        // We use a 26x26 matrix for the lowercase English letters.
        // We use a large value for infinity, but safe enough to add without overflow.
        long[][] dist = new long[26][26];
        long INF = Integer.MAX_VALUE; 

        for (long[] row : dist) {
            Arrays.fill(row, INF);
        }

        // The cost to change a character to itself is always 0
        for (int i = 0; i < 26; i++) {
            dist[i][i] = 0;
        }

        // Step 2: Populate initial costs from the input arrays
        for (int i = 0; i < original.length; i++) {
            int u = original[i] - 'a';
            int v = changed[i] - 'a';
            // Handle multiple edges: keep the minimum cost found so far
            dist[u][v] = Math.min(dist[u][v], cost[i]);
        }

        // Step 3: Floyd-Warshall Algorithm
        // Update paths using intermediate node 'k'
        for (int k = 0; k < 26; k++) {
            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < 26; j++) {
                    // If going through k is cheaper, update dist[i][j]
                    if (dist[i][k] < INF && dist[k][j] < INF) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }

        // Step 4: Calculate total cost for the source -> target transformation
        long totalCost = 0;
        int n = source.length();

        for (int i = 0; i < n; i++) {
            int u = source.charAt(i) - 'a';
            int v = target.charAt(i) - 'a';

            if (u == v) continue; // No change needed

            // If the cost is still INF, transformation is impossible
            if (dist[u][v] >= INF) {
                return -1;
            }

            totalCost += dist[u][v];
        }

        return totalCost;
    }
}