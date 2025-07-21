class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>(numCourses);
        for (int i = 0; i < numCourses; i++) adj.add(new ArrayList<>());
        for (int[] p : prerequisites) adj.get(p[1]).add(p[0]);

        boolean[] visited = new boolean[numCourses]; // black
        boolean[] stack   = new boolean[numCourses]; // gray

        for (int v = 0; v < numCourses; v++)
            if (!visited[v] && hasCycle(v, adj, visited, stack))
                return false;

        return true; // no cycle found
    }

    private boolean hasCycle(int u, List<List<Integer>> g,
                              boolean[] visited, boolean[] stack) {
        if (stack[u])   return true;   // cycle
        if (visited[u]) return false;  // already finished

        stack[u] = true;
        for (int v : g.get(u))
            if (hasCycle(v, g, visited, stack)) return true;
        stack[u] = false;

        visited[u] = true;
        return false;
    }
}
