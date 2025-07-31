class Solution {
    public int minimumEffortPath(int[][] heights) {
        int row = heights.length;
        int col = heights[0].length;

        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((x,y) -> Integer.compare(x[2],y[2]));
        int[][] dir = {{0,1},{1,0},{-1,0},{0,-1}};

        pq.offer(new int[]{0,0,0});
        
        int[][] distance = new int[row][col];
        

        for(int[] dis : distance) Arrays.fill(dis, Integer.MAX_VALUE);
        distance[0][0] = 0;
        

        while(!pq.isEmpty()) {
            int[] curr = pq.poll();
            int r = curr[0], c= curr[1], w=curr[2];
            if(r == row-1 && c == col-1) return distance[r][c];
            for(int[] d: dir) {
                int nrow = r+d[0];
                int ncol = c+d[1];  
                if(nrow < row && ncol < col && nrow >=0 && ncol >=0) {
                    int nh = Math.abs(heights[nrow][ncol] - heights[r][c]);
                    int wd = Math.max(nh,w);
                    if(distance[nrow][ncol] > wd) {
                         distance[nrow][ncol] = wd;
                         pq.offer(new int[]{nrow,ncol,wd});
                    }
                   
                }
    
            }
        }

        return distance[row-1][col-1];
    }
}