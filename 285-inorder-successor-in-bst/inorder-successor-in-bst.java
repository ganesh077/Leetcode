/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(p.right != null) {
            TreeNode pre = p.right;
            while(pre.left != null) pre = pre.left;
            return pre;
        }

        TreeNode successor = null;
        TreeNode curr = root;

        while(curr != null) {
            if(curr.val > p.val) {
                successor = curr;
                curr = curr.left;
            }
            else
            curr = curr.right;
        }

        return successor;
    }
}