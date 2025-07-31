class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        
        int[][] paths = {{0,1},{1,0},{1,1},{-1,-1},{0,-1},{-1,0},{1,-1},{-1,1}} ;
        

        int row = grid.length;
        int col = grid[0].length;

        

        if(grid[0][0] == 1 || grid[row-1][col-1] == 1) return -1;

        boolean[][] visited = new boolean[row][col];

        Queue<int[]> q = new LinkedList<>();
        boolean found = false;

        q.add(new int[]{0,0,1});
        visited[0][0] = true;

        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0], c = curr[1], w=curr[2];
            if(r == row-1 && c == col - 1) return w;
            for(int[] path: paths) {
                int nrow = r+path[0];
                int ncol = c+path[1];

                if(nrow < row && ncol < col && nrow >=0 && ncol >=0 && grid[nrow][ncol] == 0 && !visited[nrow][ncol]) {
                    visited[nrow][ncol] = true;
                    q.offer(new int[]{nrow,ncol,w+1});
                }
            }
        }

        return -1;
    }
}