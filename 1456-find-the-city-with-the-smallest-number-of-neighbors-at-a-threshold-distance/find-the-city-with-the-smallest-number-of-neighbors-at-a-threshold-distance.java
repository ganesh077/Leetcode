class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        
        int[][] adjmatrix = new int[n][n];
        int[] count = new int[n];

        for(int[] row: adjmatrix) Arrays.fill(row, Integer.MAX_VALUE);
        for(int i=0; i<n; i++) adjmatrix[i][i] = 0;
        for(int[] edge: edges) {
            int i=edge[0], j=edge[1], w=edge[2];
            adjmatrix[i][j] = w;
            adjmatrix[j][i] = w;
        }

        for(int k=0; k<n; k++) {
            for(int i=0; i<n; i++) {
                if(adjmatrix[i][k] == Integer.MAX_VALUE) continue;
                for(int j=0; j<n; j++) {
                    if(adjmatrix[k][j] == Integer.MAX_VALUE) continue;
                    adjmatrix[i][j] = Math.min(adjmatrix[i][j], adjmatrix[i][k]+adjmatrix[k][j]);
                }
            }
        }
        

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(adjmatrix[i][j] <= distanceThreshold) {
                    count[i]++;
                }
            }
        }

        int min_val = Integer.MAX_VALUE;
        int idx = -1;

        for(int i=0; i<n; i++) {
            if(min_val >= count[i]) {
                min_val = count[i];
                idx = i;
            }
        }

        System.out.println(Arrays.toString(count));
        return idx;



    }
}