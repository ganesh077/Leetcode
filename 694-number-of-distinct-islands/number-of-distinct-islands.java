class Solution {
    public int numDistinctIslands(int[][] grid) {
        int rowmax = grid.length;
        int colmax = grid[0].length;
        Set<String> orientations = new HashSet<>();

        boolean[][] visited = new boolean[rowmax][colmax];
        int count = 0;
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j] == 1 && !visited[i][j]) {
                    count++;
                    StringBuilder sb = new StringBuilder();
                    dfs(grid, visited, i, j,rowmax, colmax, "c",sb);
                    System.out.println(sb.toString());
                    orientations.add(sb.toString());

                }
            }
        }

        return orientations.size();
    }

    public void dfs(int[][] grid, boolean[][] visited, int i, int j, int rowmax, int colmax, String orient, StringBuilder sb) {
        if(i >= rowmax || i < 0 || j >= colmax || j < 0 || grid[i][j] != 1 || visited[i][j] ) return;
        

        visited[i][j] = true;
        sb.append(orient);
        dfs(grid, visited, i+1, j,rowmax, colmax,"d",sb);
        dfs(grid, visited, i-1, j,rowmax, colmax,"u",sb);
        dfs(grid, visited, i, j+1,rowmax, colmax,"r",sb);
        dfs(grid, visited, i, j-1,rowmax, colmax,"l",sb);
        sb.append('0');
        // dfs(grid, visited, i+1, j+1,rowmax, colmax,"ud1",sb);
        // dfs(grid, visited, i-1, j+1,rowmax, colmax,"ld1",sb);
        // dfs(grid, visited, i+1, j-1,rowmax, colmax,"ud2",sb);
        // dfs(grid, visited, i-1, j-1,rowmax, colmax,"ld2",sb);

    }
}