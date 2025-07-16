class Solution {
    public int numEnclaves(int[][] grid) {
        int rowmax = grid.length;
        int colmax = grid[0].length;
        int count = 0;

        for(int i=0; i<rowmax; i++) {
            if(grid[i][0] == 1) {
                dfs(grid,i,0,rowmax,colmax);
            }
            if(grid[i][colmax-1] == 1) {
                dfs(grid,i,colmax-1,rowmax,colmax);
            }
        }

        for(int i=0; i<colmax; i++) {
            if(grid[0][i] == 1) {
                dfs(grid,0,i,rowmax,colmax);
            }
            if(grid[rowmax-1][i] == 1) {
                dfs(grid,rowmax-1,i,rowmax,colmax);
            }
        }

        for(int i=0; i<rowmax; i++) {
            for(int j=0; j<colmax; j++) {
                if(grid[i][j] == 1) {
                    count++;
                }
                if(grid[i][j] == 2) {
                    grid[i][j] = 1;
                }
            }
        }

        return count;
    }

    public void dfs(int[][] grid, int row, int col, int rowmax,int colmax) {
        if(row >= rowmax || row < 0 || col >= colmax || col < 0) return;
        if(grid[row][col] != 1) return;
        grid[row][col] = 2;
        
        dfs(grid,row+1,col,rowmax,colmax);
        dfs(grid,row-1,col,rowmax,colmax);
        dfs(grid,row,col+1,rowmax,colmax);
        dfs(grid,row,col-1,rowmax,colmax);


    }
}