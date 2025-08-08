class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        int[][] directions = new int[][] {{0,1},{0,-1},{1,0},{-1,0}};

        PriorityQueue<int[]> pq = new PriorityQueue<>((x,y) -> Integer.compare(x[2],y[2]));
        pq.add(new int[]{0,0,grid[0][0]});
        visited[0][0] = true;

        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            int row = cur[0], col= cur[1], w= cur[2];
            if(row == n-1 && col == n-1) return w;
            
            for(int[] dir: directions) {
                int nrow = row + dir[0], ncol = col+dir[1];
                if(nrow >=0 && nrow < n && ncol >= 0 && ncol < n && !visited[nrow][ncol]) {
                    int maxw = Math.max(w,grid[nrow][ncol]);
                    pq.offer(new int[]{nrow,ncol,maxw});    
                    visited[row][col] = true;
                }
            }
        }
        return -1;
    }
}