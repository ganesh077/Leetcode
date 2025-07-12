class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int original = image[sr][sc];
        if (original == color) return image;  
        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
        int rowmax = image.length;
        int colmax = image[0].length;

        int[] origin = {sr,sc};

        Queue<int[]> q = new LinkedList<>();
        image[sr][sc] = color;

        q.add(origin);

        while(!q.isEmpty()) {
            
                int[] curr = q.poll();
                int row = curr[0];
                int col = curr[1];
                //int currcolor = image[row][col];
                

                for(int[] dir:directions) {
                    int nrow = row+dir[0];
                    int ncol = col+dir[1];
                    if(nrow < rowmax && nrow >= 0 && ncol < colmax && ncol >= 0 && image[nrow][ncol] == original)                  
                        {
                            
                            q.offer(new int[]{nrow,ncol});   
                            image[nrow][ncol] = color; 
                    
                }
                }

                
            
        }

        return image;
    }
}