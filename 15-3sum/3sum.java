import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums); // Sort to handle duplicates
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue; // Skip duplicate elements
            
            int target = -nums[i]; // We need two numbers summing to -nums[i]
            HashSet<List<Integer>> seen = new HashSet<>(); // To avoid duplicate triplets
            List<List<Integer>> twoSumPairs = twoSum(nums, i, target);

            for (List<Integer> pair : twoSumPairs) {
                List<Integer> triplet = Arrays.asList(nums[i], pair.get(0), pair.get(1));
                if (!seen.contains(triplet)) {
                    seen.add(triplet);
                    result.add(triplet);
                }
            }
        }
        return result;
    }

    public List<List<Integer>> twoSum(int[] nums, int index, int target) {
        HashMap<Integer, Integer> sumFreq = new HashMap<>();
        List<List<Integer>> res = new ArrayList<>();

        for (int i = index + 1; i < nums.length; i++) { // Start after 'index'
            int complement = target - nums[i];

            if (sumFreq.containsKey(complement)) {
                res.add(Arrays.asList(complement, nums[i]));
                
                // Skip duplicate pairs (important!)
                while (i + 1 < nums.length && nums[i] == nums[i + 1]) i++;
            }
            sumFreq.put(nums[i], i);
        }
        return res;
    }
}
