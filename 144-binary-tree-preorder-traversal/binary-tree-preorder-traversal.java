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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> mystack = new Stack<TreeNode>();

        mystack.push(root);

        while(!mystack.isEmpty()) {
            TreeNode curr = mystack.pop();
            if(curr != null) {
                res.add(curr.val);
                mystack.push(curr.right);
                mystack.push(curr.left);
            }
           
        }

        return res;
        
    }
}