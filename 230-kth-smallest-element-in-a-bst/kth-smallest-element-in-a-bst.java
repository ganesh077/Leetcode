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
    private int count = 0,result = 0;;

    public int kthSmallest(TreeNode root, int k) {
        if(root == null) return 0;
        
        
        kthSmallest(root.left, k);
        count++;
        if(count == k) {
            result = root.val;
            return result;
        } 
        kthSmallest(root.right, k);

        return result;
        
}
}
