class Solution {
    class Disjoint {
        int[] par, size;

        public Disjoint(int x) {
            par = new int[x];
            size = new int[x];

            Arrays.fill(size,1);
            for(int i=0; i<x; i++) par[i] = i;
        }

        public int find(int x) {
            if(par[x] == x) return x;
            return par[x] = find(par[x]);
        }

        public boolean union(int x, int y) {
            int leadx = find(x), leady = find(y);
            if(leadx == leady) return false;

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
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        List<int[]> adj = new ArrayList<>();
        int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
        boolean[][] visited = new boolean[n][n];
        Disjoint dj = new Disjoint(n*n);

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                int flatmain = flat(n,i,j);
                visited[i][j] = true;
                for(int[] dir: directions) {
                    int r = dir[0] + i, c = dir[1] + j;
                    int flatneigh = flat(n,r,c);
                    if(isValid(n,r,c) && !visited[r][c]) {
                        int val = Math.max(grid[i][j], grid[r][c]);
                        adj.add(new int[]{flatmain,flatneigh,val});
                    }
                }
            }
        }
       Collections.sort(adj,(x,y) -> Integer.compare(x[2],y[2]));
       int max = 0;
       for (int[] in : adj) {
          System.out.println(Arrays.toString(in));
          if(dj.union(in[0],in[1])) {
            max = Math.max(max,in[2]);
          }
          if(dj.find(0) == dj.find(n*n-1)) return max;
       }
    
        return max;
        
    }

    public int flat(int len, int row, int col) {
        return len*row+col;
    }

    public boolean isValid(int max,int r ,int c) {
        if(r >= 0 && r < max && c >= 0 && c < max) return true;
        return false;
    }
}