class Solution {
    class DisjoinSet {
        private int[] par, size;
        private int components;
        public DisjoinSet(int n) {
            par = new int[n];
            size = new int[n];

            Arrays.fill(size,1);

            for(int i=0; i<n; i++) {
                par[i] = i;
            }
            components = n;
        }

        public int UnionFind(int x) {
            if(x == par[x]) return x;
            return par[x] = UnionFind(par[x]);
        }

        public void UnionSize(int x, int y) {
            int leaderx = UnionFind(x), leadery = UnionFind(y);
            if(leaderx == leadery) return;
            if(size[leaderx] > size[leadery]) {
                par[leadery] = leaderx;
                size[leaderx] += size[leadery];
            }
            else if(size[leaderx] < size[leadery]) {
                par[leaderx] = leadery;
                size[leadery] += size[leaderx];
            }
            else {
                par[leadery] = leaderx;
                size[leaderx] += size[leadery];
            }
            components--;
        }
    }
    public int makeConnected(int n, int[][] connections) {
        int cables = 0;
        
        DisjoinSet dj = new DisjoinSet(n);
        for(int[] conn : connections) {
            int x = conn[0], y = conn[1];
            if(dj.UnionFind(x) == dj.UnionFind(y)) {
                cables++;
                continue;
            }
            dj.UnionSize(x,y);
        }

       

        
        if(dj.components-1 > cables) return -1;

        return dj.components-1;
    }


}