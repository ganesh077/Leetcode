class Solution {
    public void solve(char[][] board) {
        int rowlen = board.length;
        int collen = board[0].length;
        boolean[][] visited = new boolean[rowlen][collen];

        for(int i=0; i<rowlen; i++) {
            if(board[i][0] == 'O') {
                dfs(board,i,0,visited,rowlen,collen);
            }
            if(board[i][collen-1] == 'O') {
                dfs(board,i,collen-1,visited,rowlen,collen);
            }
        }

        for(int j=0; j<collen; j++) {
            if(board[0][j] == 'O') {
                dfs(board,0,j,visited,rowlen,collen);
            }

            if(board[rowlen-1][j] == 'O') {
                dfs(board,rowlen-1,j,visited,rowlen,collen);
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

    public void dfs(char[][] board,int row,int col,boolean[][] visited,int rowmax,int colmax) {

        if(board[row][col] != 'O' || visited[row][col]) return;

        visited[row][col] = true;

        if(row+1 < rowmax) {
            dfs(board,row+1,col,visited,rowmax,colmax);
         }

         if(row-1 >= 0) {
            dfs(board,row-1,col,visited,rowmax,colmax);
         }

        if(col+1 < colmax) {
            dfs(board,row,col+1,visited,rowmax,colmax);
         }

        if(col-1 >= 0) {
            dfs(board,row,col-1,visited,rowmax,colmax);
         }



    }
}