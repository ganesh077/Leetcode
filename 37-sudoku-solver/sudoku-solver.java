class Solution {
    // rows[r][d] == true  ⇔ digit d already used in row r
    private final boolean[][] rows  = new boolean[9][10];
    private final boolean[][] cols  = new boolean[9][10];
    private final boolean[][] boxes = new boolean[9][10];

    public void solveSudoku(char[][] board) {
        // initialise state from the partially-filled board
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char ch = board[r][c];
                if (ch != '.') {
                    int d = ch - '0';
                    int b = boxIndex(r, c);
                    rows[r][d] = cols[c][d] = boxes[b][d] = true;
                }
            }
        }
        backtrack(board, 0, 0);
    }

    private boolean backtrack(char[][] board, int r, int c) {
        // advance to the next empty cell
        while (r < 9 && board[r][c] != '.') {
            if (++c == 9) { r++; c = 0; }
        }
        if (r == 9) return true;          // solved entire board

        int box = boxIndex(r, c);
        for (int d = 1; d <= 9; d++) {
            if (!rows[r][d] && !cols[c][d] && !boxes[box][d]) {
                // place digit
                board[r][c] = (char) ('0' + d);
                rows[r][d] = cols[c][d] = boxes[box][d] = true;

                if (backtrack(board, r, c)) return true;  // solved

                // undo
                board[r][c] = '.';
                rows[r][d] = cols[c][d] = boxes[box][d] = false;
            }
        }
        return false;  // trigger further backtracking
    }

    private int boxIndex(int r, int c) {   // 0..8
        return (r / 3) * 3 + c / 3;
    }
}
