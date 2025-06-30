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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Queue<TreeNode> q = new ArrayDeque<TreeNode>();

        if(root == null) return res;
        q.add(root);
        int level = 0;

        while(!q.isEmpty()) {
            level +=1;
            List<Integer> levels = new ArrayList<Integer>();
            int size = q.size();
            for(int i=0; i<size; i++) {
                TreeNode node = q.remove();
                int val = node.val;
                levels.add(val);
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
            }
            if(level%2 == 0) Collections.reverse(levels);
            res.add(levels);
        }

        

        return res;
    }
}