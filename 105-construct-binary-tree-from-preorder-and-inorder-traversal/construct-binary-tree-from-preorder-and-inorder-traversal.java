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
    private int preidx = 0;
    private HashMap<Integer,Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        if(n == 0) return null;
        if(n == 1) return new TreeNode(preorder[0]);

        for(int i=0; i<inorder.length; i++) 
        { 
            map.put(inorder[i],i);
        }
        return helper(preorder,0,n-1);
    }

    public TreeNode helper(int[] preorder, int start,int end) {
        if(start > end) return null;

        int root = preorder[preidx++];
        TreeNode rootval = new TreeNode(root);
        int index = map.get(root);

        rootval.left = helper(preorder,start,index-1);
        rootval.right = helper(preorder,index+1,end);

        return rootval;

    }


}