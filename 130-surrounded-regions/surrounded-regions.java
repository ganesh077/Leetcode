class Solution {
    public void solve(char[][] board) {
        int rowlen = board.length;
        int collen = board[0].length;
        boolean[][] visited = new boolean[rowlen][collen];

        for(int i=0; i<rowlen; i++) {
            if(board[i][0] == 'O') {
                bfs(board,i,0,visited,rowlen,collen);
            }
            if(board[i][collen-1] == 'O') {
                bfs(board,i,collen-1,visited,rowlen,collen);
            }
        }

        for(int j=0; j<collen; j++) {
            if(board[0][j] == 'O') {
                bfs(board,0,j,visited,rowlen,collen);
            }

            if(board[rowlen-1][j] == 'O') {
                bfs(board,rowlen-1,j,visited,rowlen,collen);
            }
        }

        for(int i=0; i<rowlen; i++) {
            for(int j=0; j<collen; j++) {
                if(board[i][j] == 'O' && !visited[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    public void bfs(char[][] board,int row,int col,boolean[][] visited,int rowmax,int colmax) {
        Queue<int[]> p = new LinkedList<>();
        p.add(new int[]{row,col});

        visited[row][col] = true;
        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};

        while(!p.isEmpty()) {
            int size = p.size();
            for(int i=0; i<size; i++) {
                int[] curr = p.remove();
                for(int[] dir:directions) {
                    int currow = curr[0] + dir[0];
                    int curcol = curr[1] + dir[1];
                    if(currow >=0 && currow < rowmax && curcol >=0 && curcol < colmax && !visited[currow][curcol] && board[currow][curcol] == 'O') {
                        p.add(new int[]{currow,curcol});
                        visited[currow][curcol] = true;
                    }
                }
            }
        }
    }
}