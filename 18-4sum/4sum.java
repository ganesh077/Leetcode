class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int len = nums.length;

        for(int i=0; i<len-3; i++) {
            if (i>0 && nums[i] == nums[i-1]) continue;
            for (int j = i+1; j<len-2; j++) {
                if (j>i+1 && nums[j] == nums[j-1]) continue;
                int left = j+1;
                int right = len - 1;
                long starget = (long)target-nums[i]-nums[j];
                while (left < right) {
                    long sum = (long)nums[left] + nums[right];
                    if (sum == starget) {
                        result.add(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));
                        while(left < right && nums[left] == nums[left+1]) left++;
                        while(left < right && nums[right] == nums[right-1]) right--;
                        left++;
                        right--;
                    }
                    else if (sum > starget) {
                        right--;
                    }
                    else {
                        left++;
                    }
                }
            }
        }

        return result;

    }
}