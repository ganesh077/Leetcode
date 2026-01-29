import java.util.*;

class Solution {
    public int minCost(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        // 1. Flatten the grid and sort all cells by value
        // Store as int[]{row, col, value}
        List<int[]> sortedCells = new ArrayList<>(m * n);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sortedCells.add(new int[]{i, j, grid[i][j]});
            }
        }
        // Sort in ascending order of value
        Collections.sort(sortedCells, (a, b) -> Integer.compare(a[2], b[2]));

        // 2. Setup Dijkstra
        int[][][] minCosts = new int[m][n][k + 1];
        for (int[][] row : minCosts) {
            for (int[] col : row) {
                Arrays.fill(col, Integer.MAX_VALUE);
            }
        }

        // Priority Queue: {cost, row, col, k_used}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        // Initialize start
        minCosts[0][0][0] = 0;
        pq.offer(new int[]{0, 0, 0, 0});

        // 3. The "Unlock" Pointer Array
        // unlockIdx[t] tracks our progress in the sortedCells list for 't' teleports used.
        // It means: "For layer t, we have already processed cells up to index unlockIdx[t]"
        int[] unlockIdx = new int[k + 1];

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int cost = curr[0];
            int r = curr[1];
            int c = curr[2];
            int kUsed = curr[3];

            // Target reached
            if (r == m - 1 && c == n - 1) {
                return cost;
            }

            // Pruning
            if (cost > minCosts[r][c][kUsed]) continue;

            // --- Move 1: Normal Moves (Right, Down) ---
            int[][] directions = {{0, 1}, {1, 0}};
            for (int[] d : directions) {
                int nr = r + d[0];
                int nc = c + d[1];
                if (nr >= 0 && nr < m && nc >= 0 && nc < n) {
                    int newCost = cost + grid[nr][nc];
                    if (newCost < minCosts[nr][nc][kUsed]) {
                        minCosts[nr][nc][kUsed] = newCost;
                        pq.offer(new int[]{newCost, nr, nc, kUsed});
                    }
                }
            }

            // --- Move 2: Teleport Moves (Sort + Pointer Optimization) ---
            if (kUsed < k) {
                int nextK = kUsed + 1;
                
                // Get the pointer for the next layer
                int ptr = unlockIdx[nextK];
                
                // Process all cells in the sorted list that we can "unlock"
                // Condition: Cell value <= Current grid value
                while (ptr < sortedCells.size() && sortedCells.get(ptr)[2] <= grid[r][c]) {
                    int[] target = sortedCells.get(ptr);
                    int tr = target[0];
                    int tc = target[1];
                    
                    // We found a valid teleport target.
                    // Since it's a teleport, cost doesn't increase, but kUsed does.
                    if (cost < minCosts[tr][tc][nextK]) {
                        minCosts[tr][tc][nextK] = cost;
                        pq.offer(new int[]{cost, tr, tc, nextK});
                    }
                    
                    // Move the pointer forward so we never check this cell for this layer again
                    ptr++;
                }
                
                // Save the new pointer position
                unlockIdx[nextK] = ptr;
            }
        }

        return -1; // Should not happen
    }
}