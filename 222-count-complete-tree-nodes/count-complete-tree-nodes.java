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
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        int l = findH(root.left);
        int r = findH(root.right);

        if (l == r) {
            // Left subtree is perfect
            return (1 << l) + countNodes(root.right);
        } else {
            // Right subtree is perfect but one level shorter
            return (1 << r) + countNodes(root.left);
        }

    }

    public int findH(TreeNode root) {
        if(root == null) return 0;
        return 1+findH(root.left);
    }
}