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
    private int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
       helper(root);
        return max;
    }

    public int helper(TreeNode root) {
        if(root == null) return 0;

        int lv = helper(root.left);
        int rv = helper(root.right);

        max = Math.max(Math.max(max, root.val+lv+rv),Math.max(max, root.val+lv));
        max = Math.max(Math.max(max, root.val+rv),Math.max(max, root.val));

        return root.val + Math.max(0,Math.max(lv,rv));
    }
}