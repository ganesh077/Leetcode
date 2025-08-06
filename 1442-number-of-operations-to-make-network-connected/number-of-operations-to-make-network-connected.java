class Solution {
    class DisjoinSet {
        private int[] par, size;
        public DisjoinSet(int n) {
            par = new int[n];
            size = new int[n];

            Arrays.fill(size,1);

            for(int i=0; i<n; i++) {
                par[i] = i;
            }
        }

        public int UnionFind(int x) {
            if(x == par[x]) return x;
            return par[x] = UnionFind(par[x]);
        }

        public void UnionSize(int x, int y) {
            int leaderx = UnionFind(x), leadery = UnionFind(y);

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
        }
    }
    public int makeConnected(int n, int[][] connections) {
        int cables = 0;
        Set<Integer> components = new HashSet<>();;
        DisjoinSet dj = new DisjoinSet(n);
        for(int[] conn : connections) {
            int x = conn[0], y = conn[1];
            if(dj.UnionFind(x) == dj.UnionFind(y)) {
                cables++;
                continue;
            }
            dj.UnionSize(x,y);
        }

        for(int i=0; i<n; i++) {
            components.add(dj.UnionFind(i));
        }

        System.out.println(components + " " + cables);
        if(components.size()-1 > cables) return -1;

        return components.size()-1;
    }


}