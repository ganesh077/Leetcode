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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;

        if(root.val == key) {
            if(root.left != null && root.right != null) {
                TreeNode pre = root.right;
                while(pre.left != null) pre = pre.left;
                root.val = pre.val;
                root.right = deleteNode(root.right, pre.val);
            }
            
            else if(root.left == null && root.right == null) return null;
            
            else return root.left == null?root.right:root.left;
            
            
        }

        if(key > root.val) {
            root.right = deleteNode(root.right, key);
        }
        else {
            root.left = deleteNode(root.left, key);
        }
        return root;
    }
}