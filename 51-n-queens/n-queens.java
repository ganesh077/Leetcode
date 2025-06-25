class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<List<String>>();
        HashSet<Integer> colcheck = new HashSet<>();
        HashSet<Integer> upperD = new HashSet<>();
        HashSet<Integer> lowerD = new HashSet<>();
        char[][] current = new char[n][n];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                current[i][j] = '.';
            }
        }
        backtrack(res, n,current, 0,colcheck,upperD,lowerD);
        return res;
    }

    public void backtrack(List<List<String>> res,int n,char[][] current, int r, HashSet<Integer> colcheck, HashSet<Integer> upperD, HashSet<Integer> lowerD) {
        
        if(r == n) {
            res.add(render(current));
            return;
        }

        for(int c=0; c<n; c++) {
            if(colcheck.contains(c) || upperD.contains(r+c) || lowerD.contains(r-c)) continue;

            current[r][c] = 'Q';
            colcheck.add(c);
            lowerD.add(r-c);
            upperD.add(r+c);

            backtrack(res, n,current, r+1,colcheck,upperD,lowerD);

            current[r][c] = '.';
            colcheck.remove(c);
            lowerD.remove(r-c);
            upperD.remove(r+c);

        }

    }

    public List<String> render(char[][] board) {
        List<String> current = new ArrayList<String>();

        for(char[] i: board) {
            current.add(String.valueOf(i));
        }

        return current;
    }

    
}
