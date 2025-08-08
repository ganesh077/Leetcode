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
  Disjoint ds = new Disjoint(n*n);
  boolean hasZero = false;
  int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

  // Phase 1: union all adjacent 1’s
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) {
      if (grid[i][j] == 1) {
        int u = i*n + j;
        for (int[] d : dirs) {
          int r = i + d[0], c = j + d[1];
          if (r>=0 && r<n && c>=0 && c<n && grid[r][c]==1)
            ds.union(u, r*n + c);
        }
      } else {
        hasZero = true;
      }
    }
  }

  // Get max island size without any flips
  int max = hasZero ? 0 : n*n;
  for (int idx = 0; idx < n*n; idx++) {
    if (ds.find(idx) == idx) 
      max = Math.max(max, ds.size[idx]);
  }

  // Phase 2: for each zero, collect unique neighbor-roots and sum sizes+1
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) {
      if (grid[i][j] == 0) {
        Set<Integer> neigh = new HashSet<>();
        for (int[] d : dirs) {
          int r = i + d[0], c = j + d[1];
          if (r>=0 && r<n && c>=0 && c<n && grid[r][c]==1)
            neigh.add(ds.find(r*n + c));
        }
        int sum = 1;
        for (int root : neigh)
          sum += ds.size[root];
        max = Math.max(max, sum);
      }
    }
  }

  return max;
}

}