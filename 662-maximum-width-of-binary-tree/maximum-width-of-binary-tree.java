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

    public class Nodeg {
        TreeNode node;
        int index;

        public Nodeg(TreeNode node, int index) {
            this.node = node;
            this.index = index;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        Queue<Nodeg> q = new LinkedList<>();
        q.add(new Nodeg(root,0));
        int max = 0,level = 0;
        Nodeg first = new Nodeg(root,0);
        Nodeg last = new Nodeg(root,0);

        while(!q.isEmpty()) {
            level++;
            int size = q.size();
            for(int i=0; i < size; i++) {
                Nodeg val = q.remove();
                if(i==0) first = val;
                if(i==size-1) last = val;
                if(val.node.left != null) q.add(new Nodeg(val.node.left,2*val.index));
                if(val.node.right != null) q.add(new Nodeg(val.node.right,2*val.index+1));
            }
            max = Math.max(max,(last.index - first.index + 1));
        }

        return max;
    }
}