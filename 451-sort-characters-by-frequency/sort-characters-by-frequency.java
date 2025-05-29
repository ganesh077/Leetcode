class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char ch : s.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }

        // Step 2: Create a TreeSet with comparator that sorts by count
        Set<Map.Entry<Character, Integer>> sortedSet = new TreeSet<>(
            (a, b) -> {
                int cmp = Integer.compare( b.getValue(),a.getValue());
                if (cmp == 0) {
                    return Character.compare(a.getKey(), b.getKey()); // fallback to key to avoid duplicates
                }
                return cmp;
            }
        );

        sortedSet.addAll(freqMap.entrySet());

        // Step 3: Print sorted entries
        for (Map.Entry<Character, Integer> entry : sortedSet) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        StringBuilder sb = new StringBuilder();

        for(Map.Entry<Character, Integer> entry : sortedSet) {
            char ch = entry.getKey();
            int count = entry.getValue();
            for(int i=0; i<count; i++) {
                sb.append(ch);
            }
            
        }
        
        return sb.toString();
    }
}