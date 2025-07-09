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
        return helper(Integer.MIN_VALUE,Integer.MAX_VALUE,preorder);

    }

    public TreeNode helper(int low, int high,int[] preorder) {
        if(pre == preorder.length) return null;

        int val = preorder[pre];
        if(val > high || val < low) return null;
        TreeNode treeval = new TreeNode(val);
        pre++;

        

        treeval.left = helper(low,val-1,preorder);
        treeval.right = helper(val+1,high,preorder);

        return treeval;
    }
}