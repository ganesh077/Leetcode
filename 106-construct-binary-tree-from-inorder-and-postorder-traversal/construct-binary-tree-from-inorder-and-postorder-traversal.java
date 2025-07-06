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
    HashMap<Integer,Integer> map = new HashMap<>();
    int postidx;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int len = postorder.length;
        postidx = len - 1;
        if(len==0) return null;
        if(len==1) return new TreeNode(postorder[0]);
        for(int i=0; i<inorder.length; i++) {
            map.put(inorder[i],i);
        }
        return helper(postorder,0,len-1);
    }

    public TreeNode helper(int[] postorder, int start, int end) {
        if(start > end) return null;

        int rootval = postorder[postidx--];
        TreeNode root = new TreeNode(rootval);
        int idx = map.get(rootval);


        root.right = helper(postorder, idx+1, end);
        root.left = helper(postorder, start, idx-1);
        

        return root;
    }
}