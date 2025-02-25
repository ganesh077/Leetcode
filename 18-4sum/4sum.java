class Solution {
     public List<List<Integer>> Ksum(int[] nums, long target, int k, int start) {
       
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if (k==2) {
            int left = start;
            int right = nums.length - 1;
            for (int j = start; j < nums.length ; j++) {
                if (j>start+1 && nums[j] == nums[j-1]) continue;
                while (left < right) {
                    long sum = (long)nums[left] + nums[right];
                    if (sum == target) {
                        result.add(Arrays.asList(nums[left],nums[right]));
                        while(left < right && nums[left] == nums[left+1]) left++;
                        while(left < right && nums[right] == nums[right-1]) right--;
                        left++;
                        right--;
                    }
                    else if (sum > target) {
                        right--;
                    }
                    else {
                        left++;
                    }
                }
            }
        }
        else {
            for (int i=start; i < nums.length-(k-1); i++) {
                if (i>start && nums[i] == nums[i-1]) continue;
                List<List<Integer>> subList = Ksum(nums, (long)target-nums[i], k-1, i+1);
                for (List<Integer> sub: subList) {
                    List<Integer> temp = new ArrayList<Integer>(sub);
                    temp.add(0,nums[i]);
                    result.add(temp);
                }
            }
            
        }

        return result;

    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
         Arrays.sort(nums);
         return Ksum(nums,target,4,0);
    }
   
}