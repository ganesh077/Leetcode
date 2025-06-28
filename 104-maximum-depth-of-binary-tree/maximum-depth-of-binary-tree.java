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
    public int maxDepth(TreeNode root) {
       
        return helper(0, root);
   
    }

    public int helper(int length, TreeNode root) {
        if(root == null) {
            return length;
        }
        
        return Math.max(helper(length+1,root.left), helper(length+1,root.right));

    }
}