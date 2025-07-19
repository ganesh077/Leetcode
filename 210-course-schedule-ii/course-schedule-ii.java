class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Queue<Integer> q = new LinkedList<>();
        int[] order = new int[numCourses];
        int[] indegrees = new int[numCourses];
        ArrayList<List<Integer>> connections = new ArrayList<>(); 
        for(int i=0; i<numCourses; i++) connections.add(new ArrayList<>());
        int count = 0;
        Arrays.fill(indegrees,0);

        for(int[] pre: prerequisites) {
            connections.get(pre[1]).add(pre[0]);
            indegrees[pre[0]]++;
        }

        for(int i=0;i<indegrees.length;i++) {
            if(indegrees[i] == 0) {
                q.add(i);
                order[count++] = i;
            }
        }

        while(!q.isEmpty()) {
            int size = q.size();

            for(int i=0; i<size; i++) {
                int curr = q.remove();
                List<Integer> adj = connections.get(curr);
                for(int val: adj) {
                    indegrees[val]--;

                    if(indegrees[val] == 0) {
                        q.add(val);
                        order[count++] = val;
                        

                    }
                    }
                }

            }

            if(count == numCourses) {
            return order;
        }
        else {
            return new int[]{};
        }
        }

        
    }