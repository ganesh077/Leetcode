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
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        q.add(root);
        int level = 0;
        while(!q.isEmpty()) {
            level++;
            res.add(q.peek().val);
            int size = q.size();
            for(int i=0; i<size; i++) {
                TreeNode val = q.remove();
                if(val.right != null) q.add(val.right);
                if(val.left != null) q.add(val.left);
                
            }
        }

        return res;
    }
}