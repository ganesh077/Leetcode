class Solution {
    class Disjoint {
            int[] par, size;
            
            public Disjoint(int n) {
                par = new int[n];
                size = new int[n];  
                Arrays.fill(size,1);
                for(int i=0; i<n; i++) {
                    par[i] = i;
                }          
            }

            public int find(int x) {
                if(par[x] == x) return x;
                return par[x] = find(par[x]);
            }

            public boolean union(int x, int y) {
                int leadx = find(x), leady = find(y);

                if(leadx == leady) return false;;

                if(size[leadx] >= size[leady]) {
                    par[leady] = leadx;
                    size[leadx] += size[leady];
                }
                else {
                    par[leadx] = leady;
                    size[leady] += size[leadx];
                }

                return true;
            }
        }
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        Disjoint ds = new Disjoint(m*n);
        int[][] matrix = new int[m][n];
        for(int[] row: matrix) Arrays.fill(row,0);
        int[][] directions = {{0,1},{0,-1},{-1,0},{1,0}};
        Set<Integer> seen = new HashSet<>();
        List<Integer> res = new ArrayList<>();
        int count = 0;

        for(int[] pos: positions) {
            int r = pos[0], c = pos[1];
            int x = mapto(n,r,c);
            if(matrix[r][c] == 1) {
                res.add(count);
                continue;
            }
            for(int[] dir: directions) {
                int row = r + dir[0], col = c + dir[1];
                if(row < m && row >=0 && col < n && col >= 0) {
                    if(matrix[row][col] == 1) {
                        int y = mapto(n,row,col);
                        if(ds.union(x,y)) count--;;  
                    }
                    
                }
            }
            matrix[r][c] = 1;
            count++;
            res.add(count);
        }


        return res;


    }

    public int mapto(int row, int r, int c) {
        return row*r+c;
    }
}