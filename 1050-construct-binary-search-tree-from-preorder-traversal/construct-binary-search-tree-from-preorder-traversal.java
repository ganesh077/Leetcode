/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private int pre = 0;
    public TreeNode bstFromPreorder(int[] preorder) {
        int len = preorder.length;
        return helper(0,len-1,preorder);

    }

    public TreeNode helper(int start, int end,int[] preorder) {
        if(start > end) return null;

        int val = preorder[pre++];
        TreeNode treeval = new TreeNode(val);
        int split = start+1;
        while(split <= end && val > preorder[split]) {
            split++;
        }
        

        treeval.left = helper(start+1,split-1,preorder);
        treeval.right = helper(split,end,preorder);

        return treeval;
    }
}