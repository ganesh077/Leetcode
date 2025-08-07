class Solution {
    class Disjoint {
        Map<String,String> par;
        Map<String,Integer> size;
        public Disjoint(int n, Set<String> uni) {
            par = new HashMap<>();
            size = new HashMap<>();
            for (String item : uni) {
                par.put(item,item);
                size.put(item,1);
            }
        }

        public String find(String a) {
            if(par.get(a).equals(a)) return a;
            par.replace(a, find(par.get(a)));
            return par.get(a);
        }

        public void union(String a, String b) {
            String leada = find(a), leadb = find(b);
            if(leada.equals(leadb)) return;

            if(size.get(leada) >= size.get(leadb)) {
                par.replace(leadb, leada);
                size.replace(leada, size.get(leada)+size.get(leadb));
            }

            else if(size.get(leada) < size.get(leadb)) {
                par.replace(leada, leadb);
                size.replace(leadb, size.get(leada)+size.get(leadb));
            }

        }
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> result = new ArrayList<>();
        Map<String,String> mymap = new HashMap<>();
        Set<String> uni = new HashSet<>();
        for(List<String> account: accounts) {
            String name = account.get(0);
            for(int i=1; i<account.size(); i++) {
                mymap.put(account.get(i),name);
                uni.add(account.get(i));
            }
        }

        Disjoint ds = new Disjoint(uni.size(),uni);

        for(List<String> account: accounts) {
            String main = account.get(1);
            for(int i=2; i<account.size(); i++) {
                ds.union(main, account.get(i));
            }
        }

        Map<String,Set<String>> temp = new HashMap<>();
        for(List<String> account: accounts) {
            for(int i=1; i<account.size(); i++) {
                    String email = account.get(i);
                    String root = ds.find(email);
                    temp.computeIfAbsent(root, x -> new HashSet<>()).add(email);    
            }
           
        }

        for(Map.Entry<String,Set<String>> val: temp.entrySet()) {
            
            List<String> emails = new ArrayList<>(val.getValue());
            Collections.sort(emails);

            List<String> merge = new ArrayList<>();
            merge.add(mymap.get(val.getKey()));
            merge.addAll(emails);
            result.add(merge);
        }


        return result;
    }
}