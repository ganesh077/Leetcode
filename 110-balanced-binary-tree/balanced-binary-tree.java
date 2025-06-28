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
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
       System.out.println(helper(0,root.left)+" "+helper(0,root.right));
        if(Math.abs(helper(0,root.left) - helper(0,root.right)) > 1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    public int helper(int len,TreeNode root) {
        if(root == null) return len;

        return Math.max(helper(len+1,root.left),helper(len+1,root.right));
    }

}