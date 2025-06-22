class Solution {
    public boolean exist(char[][] board, String word) {
        int r = board.length;
        int c = board[0].length;
        boolean[] valid = new boolean[word.length()];

        if(word.length() > r*c) {
            return false;
        }

        int[] ascii = new int[256];

        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                ascii[board[i][j]]++;
            }
        }

        for(char i: word.toCharArray()) {
            if(ascii[i]-- < 0) return false;
        }

        

        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                if(search(board,word,0,i,j,new boolean[r][c])) return true;
            }
        }
        return false;
    }

    public boolean search(char[][] board, String word, int pos, int row, int col, boolean[][] seen) {
        if(pos == word.length()) return true;

        if(row < 0 || col < 0 || row == board.length || col == board[0].length) return false;

        if(seen[row][col] || board[row][col] != word.charAt(pos)) return false;

        seen[row][col] = true;

        boolean found = (
            search(board,word,pos+1,row+1,col,seen) ||
            search(board,word,pos+1,row,col+1,seen) ||
            search(board,word,pos+1,row-1,col,seen) ||
            search(board,word,pos+1,row,col-1,seen)
        );

        seen[row][col] = false;
        return found;
    }
}