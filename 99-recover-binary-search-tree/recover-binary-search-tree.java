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
    private TreeNode first;
    private TreeNode sec;
    private TreeNode prev = new TreeNode(Integer.MIN_VALUE);
    public void recoverTree(TreeNode root) {
        helper(root);
        int temp = first.val;
        first.val = sec.val;
        sec.val = temp;
    }

    public void helper(TreeNode root) {
        if(root == null) return;

       helper(root.left);
       if(first == null && prev.val > root.val) {
        first = prev;
       }
       if(first != null && prev.val > root.val) {
        sec = root;
       }

       prev = root;
        
       helper(root.right);
    
    }
}