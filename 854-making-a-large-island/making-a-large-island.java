class Solution {
    class Disjoint {
        int[] par, size;
        public Disjoint(int n) {
            par = new int[n];
            size = new int[n];

            Arrays.fill(size,1);
            for(int i=0; i<n;i++) {
                par[i] = i;
            }
        }

        public int find(int x) {
            if(par[x] == x) return x;
            return par[x] = find(par[x]);
        }

        public int findsize(int x) {
            return size[find(x)];
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
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
        Disjoint ds = new Disjoint(n*n);
        Map<Integer, Set<Integer>> mymap = new HashMap<>();
        boolean hasZero = false;
        boolean hasOne = false;

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == 1) {
                    hasOne = true;
                    int flat = flatten(n,i,j);
                    for(int[] dir: directions) {
                        int r = i+dir[0], c = j+dir[1];
                        int nflat = flatten(n,r,c);
                        if(r >= 0 && r < n && c >=0 && c < n) {
                            if(grid[r][c] == 1) {
                                ds.union(flat,nflat);
                            }
                        }
                 }
                }
                else {
                    hasZero = true;
                }
            }
        }

        if(!hasOne)  return 1;
        int max = hasZero? 0:n*n;
         
        for (int idx = 0; idx < n*n; idx++) {
            if (ds.find(idx) == idx) 
            max = Math.max(max, ds.size[idx]);
  }
    

         for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == 0) {
                    int flat = flatten(n,i,j);
                    Set<Integer> myset = new HashSet<>();
                    for(int[] dir: directions) {
                        int r = i+dir[0], c = j+dir[1];
                        int nflat = flatten(n,r,c);
                        if(r >= 0 && r < n && c >=0 && c < n) {
                            if(grid[r][c] == 1) {
                                myset.add(ds.find(nflat));
                            }
                        }
                    }
                    
                    int sum = 1;
                    for(int k: myset) {
                        sum += ds.findsize(k);
                    }
                    max = Math.max(max, sum);
                }
            }

        }

        return max;

        

    }

    public int flatten(int len, int r , int c) {
        return len*r+c;
    }
}