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
        int l = findH(root);
        int r = findR(root);

        if (l == r) {
            // Left n right subtree are perfect
            return (1 << l)-1;
        } else {
            return 1 + countNodes(root.left) + countNodes(root.right);
        }

    }

    public int findH(TreeNode root) {
        if(root == null) return 0;
        return 1+findH(root.left);
    }

    public int findR(TreeNode root) {
        if(root == null) return 0;
        return 1+findR(root.right);
    }
}