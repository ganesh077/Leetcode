class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int rowmax = mat.length;
        int colmax = mat[0].length;

        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[rowmax][colmax];


        for(int i=0; i<rowmax; i++) {
            for(int j=0; j<colmax; j++) {
                if(mat[i][j] == 0) {
                    q.add(new int[]{i,j});
                    visited[i][j] = true;
                }
            }
        }

        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};

        while(!q.isEmpty()) {
            
            int size = q.size();
            for(int i=0;i<size;i++) {
                int[] curr = q.remove();
                int nrow = curr[0];
                int ncol = curr[1];

                for(int[] dir:directions) {
                    int r = nrow+dir[0];
                    int c = ncol+dir[1];

                    if(r >= 0 && r < rowmax && c >= 0 && c < colmax && !visited[r][c]) {
                        mat[r][c] = mat[nrow][ncol] + 1;
                        visited[r][c] = true;
                        q.add(new int[]{r,c});
                    } 
                }
            }
        }

        return mat;
    }
             
}

