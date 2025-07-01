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
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        res.add(root.val);
        if(root.left == null && root.right == null) return res;
        helperl(res,root.left);
        helpere(res,root);
        helperr(res,root.right);
        return res;
    }

    public void helperl(List<Integer> res,TreeNode root) {
        if(root == null || (root.left == null && root.right == null)) return ;
        
        res.add(root.val);
        if(root.left != null) {
            helperl(res,root.left);
        }
        else {
            helperl(res,root.right);
        }

    }

    public void helperr(List<Integer> res,TreeNode root) {
        if(root == null || (root.left == null && root.right == null)) return ;
        
        
        if(root.right != null) {
            helperr(res,root.right);
        }
        else {
            helperr(res,root.left);
        }

        res.add(root.val);
    }

    public void helpere(List<Integer> res,TreeNode root) {
        if(root == null) return;
        
        if(root.left == null && root.right == null) {
            res.add(root.val);
        }
        helpere(res,root.left);
        helpere(res,root.right);
        
    }
    
}