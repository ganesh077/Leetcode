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
    public boolean isSymmetric(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)) return true;
        System.out.println(lefttree(root.left));
        System.out.println(righttree(root.right));
        if(lefttree(root.left).equals(righttree(root.right))) return true;
        return false;
    }

    public String lefttree(TreeNode root) {
        if(root == null) return ".";

        String temp = Integer.toString(root.val);
        temp += lefttree(root.left);
        temp += lefttree(root.right);
        return temp;
    }

    public String righttree(TreeNode root) {
        if(root == null) return ".";

        String temp = Integer.toString(root.val);
        temp += righttree(root.right);
        temp += righttree(root.left);
        return temp;
    }
}