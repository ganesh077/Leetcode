class Solution {
    public int[] rearrangeArray(int[] nums) {

        int[] postive_pos = new int[nums.length/2];
        int pos_poninter = 0;
        int[] negative_pos = new int[nums.length/2];
        int neg_poninter = 0;
        int[] res = new int[nums.length];
        
        for (int i=0; i<nums.length; i++) {
            if (nums[i] > 0) {
                postive_pos[pos_poninter] = nums[i];
                pos_poninter++;
            }
            else if (nums[i] < 0) {
                negative_pos[neg_poninter] = nums[i];
                neg_poninter++;
            }
            
        }

        System.out.println(Arrays.toString(postive_pos)+" "+Arrays.toString(negative_pos));

        for (int i=0; i<nums.length/2; i++) {
            res[i*2] = postive_pos[i];
            res[(i*2)+1] = negative_pos[i];   
        }
    return res;
        
}
}