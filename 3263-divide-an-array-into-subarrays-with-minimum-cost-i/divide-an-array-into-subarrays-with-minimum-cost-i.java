class Solution {
    public int minimumCost(int[] nums) {
        int first = Integer.MAX_VALUE;
        int fndx = 0;
        int second = Integer.MAX_VALUE;;
        int sndx = 0;


        for(int i=1; i<nums.length; i++) {
            if(nums[i] < first) {
                second = first;
                sndx = fndx;
                first = nums[i];
                fndx = i;
            }
            else if(nums[i] < second) {
                second = nums[i];
                sndx = i;
            }
        }

        int minIdx = Math.min(sndx, fndx);
        int maxIdx = Math.max(sndx, fndx);

        System.out.println(minIdx + " " + maxIdx);

        if(minIdx > 0) {
            return first + second + nums[0];
        }
        else if(minIdx == 0 && minIdx+1 == maxIdx) {
            
            return first + second + nums[maxIdx + 1];
        }
        else {
            
            return first + second + nums[minIdx + 1];
        }



    }
}