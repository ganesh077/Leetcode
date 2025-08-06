class Solution {
    class Disjoint {
        int[] par, size;
        public Disjoint(int r,int c) {
            int n = r+c;
            par = new int[n+1];
            size = new int[n+1];

            Arrays.fill(size,1);

            for(int i=0; i<n; i++) {
                par[i] = i;
            }
        }

        public int find(int x) {
            if(par[x] == x) return x;

            return par[x] = find(par[x]);
        }

        public void union(int x, int y) {
            int leadx = find(x), leady = find(y);

            if(leadx == leady) return ;

            if(size[leadx] >= size[leady]) {
                par[leady] = leadx;
                size[leadx] += size[leady];
            }
            else if(size[leadx] < size[leady]) {
                par[leadx] = leady;
                size[leady] += size[leadx];
            }
        }
    }
    public int removeStones(int[][] stones) {
        int len = stones.length;
        
        int row=0, col=0;
        for(int[] stone: stones) {
            row = Math.max(row,stone[0]);
            col = Math.max(col,stone[1]);
        }

        Disjoint ds = new Disjoint(row+1,col+1);
        
        Set<Integer> uni = new HashSet<>();
        for(int[] stone: stones) {
            int r = stone[0], c = stone[1]+row+1;
            ds.union(r,c);
            uni.add(r);
            uni.add(c);
        }

        int cnt = 0;
        for(int i: uni) {
            if(ds.find(i) == i) cnt++;
        }

        return len - cnt;

        
    }
}