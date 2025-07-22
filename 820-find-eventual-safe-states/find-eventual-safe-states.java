class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> safe = new ArrayList<>();
        List<List<Integer>> revadj = new ArrayList<>();
        int[] outdeg = new int[graph.length];

        for(int i=0; i<graph.length; i++) revadj.add(new ArrayList<>());

        for(int i=0; i<graph.length; i++) {
            for(int j=0; j<graph[i].length; j++) {
                revadj.get(graph[i][j]).add(i);
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<graph.length; i++ ) {
            if(graph[i].length == 0) {
                q.add(i);
            }

            outdeg[i] = graph[i].length;
        }
        //revadj.stream().forEach(System.out::println);
        //System.out.println(Arrays.toString(indeg));



        while(!q.isEmpty()) {
            int curr = q.remove();
            safe.add(curr);
            for(int i=0; i<revadj.get(curr).size();i++) {
                outdeg[revadj.get(curr).get(i)]--;
                if(outdeg[revadj.get(curr).get(i)] == 0) {
                    q.add(revadj.get(curr).get(i));
                }  
            }
        }

        Collections.sort(safe);
        return safe;

    }   
}