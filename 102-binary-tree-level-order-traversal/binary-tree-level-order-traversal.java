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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Queue<TreeNode> myq = new LinkedList<>();
        if(root == null) return res;
        myq.add(root);
        while(!myq.isEmpty()) {
            int levels = myq.size();
            List<Integer> level = new ArrayList<Integer>();

            for(int i=0; i<levels; i++) {
                TreeNode curr = myq.remove();
                level.add(curr.val);

                if(curr.left != null) myq.add(curr.left);
                if(curr.right != null) myq.add(curr.right);
            }

            res.add(level);
            
        }

        
        return res;
    }
}