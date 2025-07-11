class Solution {
    class Edge {
        int row;
        int col;

        public Edge(int row,int col) {
            this.row = row;
            this.col = col;
        }

        public int getrow(){
            return row;
        }

        public int getcol(){
            return col;
        }

    }
    public int orangesRotting(int[][] grid) {
        int rowmax = grid.length-1;
        int colmax = grid[0].length-1;
        List<Edge> rottens = new ArrayList<>();

        if(!fresh(grid)) return 0;

        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j] == 2) {
                    rottens.add(new Edge(i,j));
                }
            }
        }


        Queue<Edge> q = new LinkedList<>();

        for(Edge i: rottens) {
            q.add(i);
        }
        int minute = -1;
        while(!q.isEmpty()) {
            minute++;
            int size = q.size();
            for(int i=0; i<size; i++) {
                Edge curr = q.remove();
                int currrow = curr.getrow();
                int currcol = curr.getcol();

                if(currrow < rowmax && grid[currrow+1][currcol] == 1) {
                    grid[currrow+1][currcol] = 2;
                    q.add(new Edge(currrow+1,currcol));
                }
                if(currrow > 0 && grid[currrow-1][currcol] == 1) {
                    grid[currrow-1][currcol] = 2;
                    q.add(new Edge(currrow-1,currcol));
                }
                if(currcol < colmax && grid[currrow][currcol+1] == 1) {
                    grid[currrow][currcol+1] = 2;
                    q.add(new Edge(currrow,currcol+1));
                }
                if(currcol > 0 && grid[currrow][currcol-1] == 1) {
                    grid[currrow][currcol-1] = 2;
                    q.add(new Edge(currrow,currcol-1));
                }
            }
        }


        
        if(fresh(grid)) {
            return -1;
        }
        return minute;
        
    }


    public boolean fresh(int[][] grid) {
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    return true;
                }
            }
        }
        return false;
    }


}