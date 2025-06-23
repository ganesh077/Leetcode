class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        boolean[][] blocked = new boolean[n][n];
        backtrack(res, n, blocked, 0, new ArrayList<>());
        return res;
    }

    private void backtrack(List<List<String>> res, int n,
                           boolean[][] blocked, int row,
                           List<String> current) {
        if (row == n) {                // placed n queens → store board
            res.add(new ArrayList<>(current));
            return;
        }

        for (int col = 0; col < n; col++) {
            if (blocked[row][col]) continue;

            // 1️⃣ mark all squares this queen attacks + remember them
            List<int[]> changed = mark(row, col, blocked, n);

            // 2️⃣ add visual row (".Q..") to current board
            current.add(buildRow(col, n));

            // 3️⃣ recurse to next row
            backtrack(res, n, blocked, row + 1, current);

            // 4️⃣ undo
            current.remove(current.size() - 1);
            for (int[] p : changed) blocked[p[0]][p[1]] = false;
        }
    }

    /** Mark column & both diagonals below (row,col).  Returns list of cells flipped. */
    private List<int[]> mark(int row, int col, boolean[][] b, int n) {
        List<int[]> flipped = new ArrayList<>();

        // vertical ↓
        for (int r = row + 1; r < n; r++) if (!b[r][col]) {
            b[r][col] = true; flipped.add(new int[]{r, col});
        }
        // diag ↘
        for (int r = row + 1, c = col + 1; r < n && c < n; r++, c++) if (!b[r][c]) {
            b[r][c] = true; flipped.add(new int[]{r, c});
        }
        // diag ↙
        for (int r = row + 1, c = col - 1; r < n && c >= 0; r++, c--) if (!b[r][c]) {
            b[r][c] = true; flipped.add(new int[]{r, c});
        }
        return flipped;
    }

    private String buildRow(int qCol, int n) {
        char[] ch = new char[n];
        Arrays.fill(ch, '.');
        ch[qCol] = 'Q';
        return new String(ch);
    }
}
